CC := javac

all:
	$(CC) $(CFLAGS) -d bin src/snake/*.java
.PHONY: clean
clean:
	rm -rf bin/*
run:
	java -cp ./bin/snake TelaInicial
