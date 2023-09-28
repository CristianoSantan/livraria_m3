DROP DATABASE IF EXISTS booki;

CREATE DATABASE IF NOT EXISTS booki;

USE booki;

CREATE TABLE Usuarios (
    id_usuario INTEGER PRIMARY KEY auto_increment,
    nome_usuario VARCHAR(40),
    email_usuario VARCHAR(80),
    senha_usuario VARCHAR(40)
);

CREATE TABLE Livros (
    id_livro INTEGER PRIMARY KEY auto_increment,
    nome_livro VARCHAR(40),
    autor_livro VARCHAR(40),
    editora_livro VARCHAR(40),
    preco_livro DECIMAL(5,2)
);

CREATE TABLE Compras (
    id_compra INTEGER PRIMARY KEY auto_increment,
    data_compra VARCHAR(10),
    id_livro INTEGER,
    id_usuario INTEGER,
    total_compra DECIMAL(5,2),
    FOREIGN KEY(id_livro) REFERENCES Livros (id_livro),
    FOREIGN KEY(id_usuario) REFERENCES Usuarios (id_usuario)
);

CREATE VIEW usuario_livro AS 
select c.id_compra, c.data_compra, c.total_compra, l.*, u.* 
from Compras c, Livros l, Usuarios u 
where c.id_livro = l.id_livro and c.id_usuario = u.id_usuario;

-- salvando(create) os dados
insert into Usuarios (nome_usuario, email_usuario, senha_usuario) values 
('Denise', 'denise@email', '123'),
('Adrian', 'adrian@email', '456'),
('Patricia', 'patricia@email', '789');

insert into Livros (nome_livro, autor_livro, editora_livro, preco_livro) values 
('A Arte da Guerra', 'Sun Tzu', 'rocco', 49.9),
('Originais', 'Adam Grant', 'sextante', 29.9),
('Harry Potter', 'J. K. Rowling', 'rocco', 49.9),
('Sherlock Holmes', 'Arthur Conan Doyle', 'atlas', 35.9);

insert into Compras (data_compra, id_livro, id_usuario, total_compra) values 
('18/09/2023',  2, 1, 35.9),
('16/09/2023',  1, 2, 49.9);

-- consulta(read) dos dados
select * from Livros;
select * from Usuarios;
select * from Compras;
select * from usuario_livro order by id_compra;

select c.id_compra, c.data_compra, c.total_compra, l.*, u.* 
from Compras c, Livros l, Usuarios u 
where c.id_livro = l.id_livro and c.id_usuario = u.id_usuario;

-- atualizando(updade) os dados
UPDATE Usuarios SET nome_usuario = 'Denise Silva', email_usuario = 'denise@email', senha_usuario = '123' WHERE id_usuario = 1;
UPDATE Livros SET nome_livro = 'Harry Potter e a Pedra Filosofal', autor_livro = 'J. K. Rowling', editora_livro = 'rocco', preco_livro = 49.9 WHERE id_livro = 3;
UPDATE Compras SET data_compra = '10/09/2023', total_compra = 150, id_livro = 4, id_usuario = 3 WHERE id_compra = 1;

-- deletando(delete) os dados
DELETE FROM Usuarios WHERE id_usuario = 4;
DELETE FROM Livros WHERE id_livro = 2;
DELETE FROM Compras WHERE id_compra = 1;

-- SELECT c.id_compra, c.data_compra, l.*, u.* FROM Compras AS c RIGHT JOIN Livros AS l ON c.id_livro = l.id_livro LEFT JOIN Usuarios AS u ON c.id_usuario = u.id_usuario;

-- alter table Livros modify preco_livro DECIMAL(10,2);