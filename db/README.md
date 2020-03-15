## Docker Build

```docker
docker build -t nowait/db --force-rm .
```

## Docker Run

```docker
docker run -it -p 5432:5432 -e POSTGRES_PASSWORD=meow nowait/db
```