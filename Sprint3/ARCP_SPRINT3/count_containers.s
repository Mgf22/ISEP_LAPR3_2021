.section .data
    .global mPtr
    .global numElem

.section .text
    .global count_containers

count_containers:
    movq mPtr(%rip), %r8
    movq numElem(%rip), %r9

    movq $0, %rax #number of free slots
    movq $0, %rcx #number of full slots
    movq $-1, %r10 #counter of positions already passed

loop:
    cmpq %r9, %r10
    je end

    incq %r10

    movl (%r8, %r10, 4), %edx
    cmpl $0, %edx
    je free_slots

    incq %rcx
    jmp loop

free_slots:
    incq %rax
    jmp loop

end:
    shlq $32, %rax
    addq %rcx, %rax
    ret
