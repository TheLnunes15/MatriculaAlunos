# MatriculaAlunos
Matrícula de alunos - Programação para Web

Desenvolver um aplicativo Java para Web para fazer a solicitação de matrícula dos alunos de um determinado curso. Criar um banco de dados MySQL contendo as seguintes tabelas:
**1º)** Tabela de disciplinas (disciplinas), contendo os seguintes campos:
**a.** Código da disciplina (Exemplo: COMP0200);
**b.** Nome da disciplina (Exemplo: Programação para Web);

**2º)** Tabela de turmas ofertadas (turmas), contendo os seguintes campos: 
**a.** Código da disciplina
**b.** Código da turma (Exemplo: T01)
**c.** Horário 1 (Exemplo: 2152 -> dia(2), hora início(15), duração(2))
**d.** Horário 2: uso opcional.
**e.** Horário 3: uso opcional.
**f.** Local: didática + sala. (Exemplo: 5108 -> Did. 5, sala 108)

**3º)** Tabela de alunos (alunos), contendo:
**a.** Matrícula do aluno (Exemplo: 201310035143)
**b.** Nome do aluno (Exemplo: Maria Santana Silva)
**c.** Código do curso (Exemplo: 170)


O aplicativo deverá apresentar uma página com todas as disciplinas ofertadas em formato de tabela. Contendo os seguintes campos:
**a.** Código da disciplina
**b.** Nome da disciplina
**c.** Código da turma
**d.** Horários da turma (de 1 a 3)
**e.** Uma caixa de seleção (check box) ao lado da turma para indicar inclusão

Na página inicial o aluno deverá informar a sua matrícula. Em seguida o aplicativo deverá listar as turmas ofertadas. O usuário deverá escolher as disciplinas desejadas marcando a caixa de
seleção. Ao final da página deverá ter um botão de submissão.

Após a submissão, o aplicativo deverá gerar uma página com o título “Solicitação de Matrícula”, com todos os dados do aluno e com as disciplinas selecionadas com todas as informações da
disciplina (em formato de tabela).

Os horários deverão ser exibidos indicando o dia (Seg a Sex), a hora inicial e a hora final: 15-17.
