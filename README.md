# Atividade Siga-Comportamentais

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -encoding UTF-8 -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## Explicação cadeias condicionais

O primeiro condicional se encontra no arquivo Matricula.java no método calcularValor(). Neste método consta a utilização de bloco condicional IF para realizar a verificação do desconto a ser aplicado na matricula.

O segundo condicional está no arquivo GeradorBoleto.java no método calcularValorDoBoleto(). Ele também consta com a utilização de um bloco condicional IF para realizar o calculo do valor do boleto de acordo com o devido desconto a ser aplicado.

Ainda com as duas tendo praticamente a mesma funcionalidade, ocorreu uma divergencia que fez com que o tipo Egresso não recebesse desconto no calculo do boleto.
