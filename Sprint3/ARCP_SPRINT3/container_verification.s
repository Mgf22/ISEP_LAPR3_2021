.section .data		
	.global posx
	.global posy
	.global posz
	.global mPtr	
	
.section .text
	.global container_verification
	
container_verification:
	movl posx(%rip), %eax
	imull $400, %eax, %eax

	movl posy(%rip), %ebx
	imull $40, %ebx, %ebx
	addl %ebx, %eax

	movl posz(%rip), %ecx
	imull $4, %ecx, %ecx
	addl %ecx, %eax

	addl mPtr(%rip), %eax
	movl (%eax), %eax
	cmpl $0, %eax
	je cont_no
	jne cont_yes

cont_yes:
	mov 1, %eax
	jmp end

cont_no:
	mov 0, %eax
	jmp end

end:  	
	ret
