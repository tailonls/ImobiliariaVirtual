-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Set-2019 às 23:06
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `imobiliaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

CREATE TABLE `imovel` (
  `descricao` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `situacao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `imovel`
--

INSERT INTO `imovel` (`descricao`, `endereco`, `id`, `situacao`) VALUES
('Residencial VILLABELLA, Casas de 02 dormitórios, em alvenaria de blocos estruturais, telhas cerâmicas, esquadrias de alumínio, piso frio em todas as peças, portas internas e externas em madeira, banheiro com ventilação natural.\r\n', 'Maracanã 17', 2, 'Aguardando Regularização'),
('Área em Gravataí com 2.800metros .\r\nExcelente localização , somente 400MTS da Avenida Dorival Candido Luz de Oliveira.\r\nÓTIMA OPORTUNIDADE PARA INVESTIDORES.\r\nAceita permuta de 50% do valor da área.', 'Rua 33', 3, 'Area verde'),
('Apartamento em Cachoeirinha com 1 dormitório, living, banheiro social, cozinha e área de serviço.', 'Alberto Bins 555', 4, '4'),
('Excelente localização, em frente à praça e junto à todos os recursos de comércio e transporte do bairro.\r\n', 'Silvio Luiz 255', 5, 'Aguardando Regularização'),
('Excelente localização, em frente à praça e junto à todos os recursos de comércio e transporte do bairro.\r\n', 'Maracanã 17', 6, 'indefinido');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `imovel`
--
ALTER TABLE `imovel`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
