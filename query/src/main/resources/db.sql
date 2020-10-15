CREATE TABLE aluno
(
    id VARCHAR(36),
    nome VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(255),
    matricula VARCHAR(36),
    formaIngresso VARCHAR(255),
    CONSTRAINT aluno_pkey PRIMARY KEY (id)
)

CREATE TABLE professor
(
    id VARCHAR(36),
    nome VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(255),
    titulacao VARCHAR(255),
    CONSTRAINT professor_key PRIMARY KEY (id)
)

CREATE TABLE disciplina
(
    id VARCHAR(36),
    descricao VARCHAR(255),
    anoLetivo INTEGER,
    periodoLetivo INTEGER,
    numeroVagas INTEGER,
    professor_id VARCHAR(36),
    CONSTRAINT disciplina_pkey PRIMARY KEY (id)
)

CREATE TABLE turma
(
    id VARCHAR(36),
    descricao VARCHAR(255),
    sigla VARCHAR(255),
    cargaHoraria INTEGER,
    CONSTRAINT turma_pkey PRIMARY KEY (id)
)


CREATE TABLE aluno_turma
(
    aluno_id VARCHAR(36) REFERENCES aluno (id) ON UPDATE CASCADE ON DELETE CASCADE,
    turma_id VARCHAR(36) REFERENCES turma (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT aluno_turma_pkey PRIMARY KEY (turma_id, aluno_id)
)


CREATE TABLE turma_disciplina
(
    disciplina_id VARCHAR(36) REFERENCES disciplina (id) ON UPDATE CASCADE ON DELETE CASCADE,
    turma_id VARCHAR(36) REFERENCES turma (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT turma_disciplinas_pkey PRIMARY KEY (turma_id, disciplina_id)
)