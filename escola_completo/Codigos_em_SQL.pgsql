-- Inserção de um registro com valores específicos
INSERT INTO administrador (cpf, nome, email, senha)
VALUES ('12345678900', 'João da Silva', 'joao@example.com', 'minhasenha123');

-- Inserção de outro registro com valores diferentes
INSERT INTO administrador (cpf, nome, email, senha)
VALUES ('98765432100', 'Maria Souza', 'maria@example.com', 'senhamaria456');

-- Inserção de mais um registro
INSERT INTO administrador (cpf, nome, email, senha)
VALUES ('55555555555', 'Pedro Oliveira', 'pedro@example.com', 'senha123pedro');

SELECT * FROM notas;


-- Inserção de dados teste na tabela alunoINSERT INTO Aluno (ra, cpf, matricula, nome, turma, email, senha)
VALUES (12345, '123.456.789-00', 'M123', 'João da Silva', 'A', 'joao.silva@example.com', 'minhaSenha123');


INSERT INTO Aluno (ra, cpf, matricula, nome, turma, email, senha)
VALUES (67890, '987.654.321-00', 'M456', 'Maria Souza', 'B', 'maria.souza@example.com', 'outraSenha456');


INSERT INTO notas (id_notas,valor_notas, alu_ra, disc_cod_disciplina) VALUES (3,5.5, 67890, 1);

SELECT * FROM aluno;
SELECT * FROM disciplinas;
SELECT * FROM notas;

-- Codigo para mostrar as notas dos meus alunos, junto com outras informações
SELECT notas.valor_notas AS Notas,
       notas.disc_cod_disciplina AS COD_MATERIA,
       notas.alu_ra AS RA_ALUNO,
       disciplinas.nome AS Nome_Materia,
       professor.nome AS Nome_Professor
FROM notas
INNER JOIN disciplinas ON disciplinas.cod_disciplina = notas.disc_cod_disciplina
INNER JOIN professor ON professor.cpf = disciplinas.prof_cpf;



-- Suponha que sua tabela se chame "disciplina"
INSERT INTO disciplinas (cod_disciplina, nome, prof_cpf)
VALUES
    (1, 'Matemática', '12345');
