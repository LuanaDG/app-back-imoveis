--criar banco de dados/executar no mysql
CREATE DATABASE dbimoveis;


--usar o banco de dados
USE dbimoveis;

--criar tabela

CREATE TABLE imoveis (
id int(5)AUTO_INCREMENT NOT NULL,
tipo enum('CASA', 'PREDIO', 'SALA_COMERCIAL', 'PAVILHAO') NOT NULL,
material enum('ALVENARIA', 'MADEIRA', 'MISTA') NOT NULL,
tamanho double NOT NULL,
cidade varchar(250) NOT NULL,
data_construcao DATE NOT NULL,
PRIMARY KEY (id)
);



CREATE TABLE precos (
id int(5)AUTO_INCREMENT NOT NULL,
tipo enum('CASA', 'PREDIO', 'SALA_COMERCIAL', 'PAVILHAO') NOT NULL,
material enum('ALVENARIA', 'MADEIRA', 'MISTA') NOT NULL,
precoMetroQuad double NOT NULL,
PRIMARY KEY (id)
);



CREATE TABLE vendas (
	id int(5) AUTO_INCREMENT NOT NULL,
	cpf_cliente varchar(11) NOT NULL,
	nome varchar(250) NOT NULL,
	data_venda DATE NOT NULL,
	id_imovel int (5) NOT NULL,
	valor_total DECIMAL(9,2),
	PRIMARY KEY (id),
	FOREIGN KEY (id_imovel) REFERENCES imoveis(id)
);



--JOIN
SELECT imoveis.*, precos.preco_metro_quadrado
FROM imoveis LEFT JOIN precos ON(imoveis.tipo = precos.tipo AND imoveis.material = precos.material) 
;




--RELATÓRIOS

-- 1 - Relatório de vendas total / mostra todos - CERTO
SELECT vendas.* , imoveis.id as id_do_imovel, imoveis.tipo, imoveis.material,imoveis.tamanho,imoveis.cidade, imoveis.data_construcao
FROM imoveis JOIN vendas ON (imoveis.id = vendas.id_imovel);

-- 2 - Relatório de vendas por mês - CERTO
SELECT vendas.* , imoveis.id as id_do_imovel, imoveis.tipo, imoveis.material,imoveis.tamanho,imoveis.cidade, imoveis.data_construcao
FROM imoveis JOIN vendas ON (imoveis.id = vendas.id_imovel)
WHERE MONTH(data_venda) = 06 AND YEAR(data_venda) = 2020;

-- 3 - Relatório dos imóveis disponíveis
SELECT * FROM construtora.imoveis;

-- 4 -Relatório de preços ordenado por ordem  - CERTO
SELECT id_imovel, cpf_cliente, nome, data_venda, valor_total FROM vendas ORDER by valor_total ASC;
SELECT id_imovel, cpf_cliente, nome, data_venda, valor_total FROM vendas ORDER by valor_total DESC;



