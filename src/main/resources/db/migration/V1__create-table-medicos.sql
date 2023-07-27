CREATE TABLE medicos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  crm VARCHAR(100) NOT NULL UNIQUE,
  especialidade VARCHAR(50) NOT NULL,
  logradouro VARCHAR(100) NOT NULL,
  bairro VARCHAR(20) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cidade VARCHAR(20) NOT NULL,
  uf CHAR(2),
  numero VARCHAR(20) NOT NULL,
  complemento VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);