To publish packt file use following command

```
curl -v -XPUT \-H "Content-Type: application/json" \
-d@target/pacts/simple_consumer-simple_provider.json \
http://18.194.74.172:9292/pacts/provider/simple_provider/consumer/simple_consumer/version/0.0.0+4jvh387gj3
```