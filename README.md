# quarkus-jfr-npe-reproducer

Reproducer for https://github.com/quarkusio/quarkus/issues/44976

To test:
1. `quarkus dev`
2. `curl -v http://localhost:8080` -> should respond HTTP 302 Found
3. `curl -v http://localhost:8080/hello` -> should respond HTTP 200 OK, with "Hello from Quarkus REST" body
4. `curl -v http://localhost:8080/hello/upload` -> this is a POST endpoint. We should expect an HTTP 405, but instead we get HTTP 500 and an NPE stacktrace.
5. `curl -v http://localhost:8080 -H 'Accept: application/xml'` -> should respond HTTP 406 since this endpoint produces plaintext and we accept XML, but instead we get HTTP 500 and an NPE stacktrace.
6. `quarkus extension remove jfr`
7. Repeat steps 2-5
