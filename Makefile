CC := javac

all:
	$(CC) $(CFLAGS) -d bin src/*.java
.PHONY: clean
clean:
	rm -rf bin/*
run:
	java -cp ./bin Snake
