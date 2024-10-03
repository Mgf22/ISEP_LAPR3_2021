.section .text
    .global validaRefrigeracao

validaRefrigeracao:
    movl $0, %r11d
	addq $32, %rdi # tamanho da struct

loop:
	cmpl %r11d, %r8d # verificar sempre que não excede o tamanho do vetor
	je nao_refrigerado

	addq $4, %rdi # avança 4 bytes para obter x
	cmpl (%rdi), %esi
	jne mover_x	# x não é igual ao x do contentor
	
	addq $4, %rdi # avança 4 bytes para obter y
	cmpl (%rdi), %edx 
	jne mover_y # y não é igual ao y do contentor
	
	addq $4, %rdi # avança 4 bytes para obter z
	cmpl (%rdi), %ecx
	jne mover_z # z não é igual ao z do contentor
	
	addq $9, %rdi # avança 9 bytes para ir para a posição da refrigeração
	cmpl $1, (%rdi)
	je refrigerado # se for refrigerado
	jmp nao_refrigerado # se nao for refrigerado
	
mover_x:
	addq $28, %rdi # avança 28 bytes pois o x não é igual ao pedido. Salta logo para a proxima posição de vetor
	incl %r11d
	jmp loop
	
mover_y:
	addq $24, %rdi # avança 24 bytes pois o y não é igual ao pedido. Salta logo para a proxima posição de vetor
	incl %r11d
	jmp loop

mover_z:
	addq $20, %rdi # avança 20 bytes pois o z não é igual ao pedido. Salta logo para a proxima posição de vetor
	incl %r11d
	jmp loop

nao_refrigerado:
    movl $0, %eax # move 0 para eax
    jmp end

refrigerado:
    movl $1, %eax # move 1 para eax
    jmp end

end: 
    ret
