.section .data
    .global mPtr
    .global ptrvec

.section .text
    .global check_container_position

check_container_position:
    movl $0, %r12d #number of positions
    movl $0, %r11d #counter
    movl ptrvec(%rip), %r13d
    movl mPtr(%rip), %r14d
    movl $0, %r15d #number of vetor positions
    jmp loop

loop:
    incl %r15d
    cmpl $11, %r15d
    je end
    movl %r13d, %r8d
    incl %r12d
    movl (%r13d, %r12d, 4), %r9d
    incl %r12d
    movl (%r13d, %r12d, 4), %r10d
    jmp container_verification

container_verification:
    imull $400, %r8d, %eax

    imull $40, %r9d, %ebx
	addl %ebx, %eax

    imull $4, %r10d, %ecx
	addl %ecx, %eax
    
    movl (%r14d, %eax, 4), %eax
    cmpl $0, %eax
    jne increment
    je loop

increment:
    incl %r11d
    jmp loop

end:
    ret
