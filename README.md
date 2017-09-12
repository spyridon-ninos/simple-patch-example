# simple-patch-example
A simple json web service that demonstrates the use of the patch method to update the model

### Concept
The HTTP PATCH method can be used either with the json patch ([RFC 6902](https://tools.ietf.org/html/rfc6902))
or with the json patch-merge ([RFC 7386](https://tools.ietf.org/html/rfc7386)).

Those two formats make it very easy
to update a json *document*, but not a *model* that uses json only as its
serialisation format.

Given that our model has a fixed structure (in our case it is
a java class) we cannot add and/or remove fields.

So, when we deserialise from the json format
to a class, by default any field that is not present in the json body
will be initialised to its default value in the java class, which
for non-primitives is the *null* value.

This creates the problem that we cannot differentiate between the two cases:
- we don't include a field in the json body because we don't care about it
(the respective class field will be **initialised** with the *null* value)
- we want to delete the value of a field by assigning the *null* value to it (so we put
something like: *"field": null* in the json body and the class field
will be **assigned** the *null* value).

One simple solution is to have a custom json deserialiser that checks
which fields are present in the json body and only change those to
the target model. This solution is implemented in this example.

### Usage
There are two endpoints:

* GET / : this returns a dummy list with a single person
* PATCH /1 : use this to send a json of the following format:
```
{
    "firstName" : "...",
    "lastName" : "...",
    "jobType" : "unemployed" (see the JobType enum for the rest of the job types)
}
```

This will update your model. You can include all or any combination of the fields in the json body.

### Notes
I kept this example as simple and focused as possible. As such, I didn't put any 
error handling in the code. So, if you call e.g. **PATCH /2** you'll get an exception.
