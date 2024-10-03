# A Makefile with variables and suffix rules

# variaveis
INCLUDES = read_containers.h count_containers.h container_verification.h check_container_position.h
SOURCES = read_containers.c main.c count_containers.s container_verification.s check_container_position.s
OBJFILES = read_containers.o main.o count_containers.o container_verification.o check_container_position.o
EXEC = a

# Suffix rules
.SUFFIXES : .c .o

# How to build an object .o from a code file .c ; $< -- file name
.c.o:
	gcc -Wall -g -c $<
	
${EXEC}: ${OBJFILES}
	gcc -Wall -g -o ${EXEC} ${OBJFILES}
	
${OBJFILES}: ${SOURCES} ${INCLUDES}

run: ${EXEC}
	./${EXEC}
	
clean:
	rm -f ${OBJFILES} ${EXEC}
	rm -f ${OBJFILES} ${EXEC}
