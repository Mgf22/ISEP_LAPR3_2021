main: main.o US409.o US410S.o US410.o US411.o
	gcc -Wall -g main.o US409.o US410S.o US410.o US411.o -o main
		
main.o: main.c US409.h
	gcc -Wall -g -c main.c
		
US409.o: US409.c US409.h
	gcc -Wall -g -c US409.c

US410.o: US410.c
	gcc -Wall -g -c US410.c -o US410.o

US410S.o: US410.s
	gcc -Wall -g -c US410.s -o US410S.o
		
US411.o: US411.c
	gcc -Wall -g -c US411.c -o US411.o	
	
run: main
	./main
		
clean:
	rm -f ∗.o main
		
debug:
	gdb -tui ./main
