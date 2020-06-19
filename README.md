Projeto CRUD em JAVA - JAVA, JDBC e MySQL

Desenvolvimento de um simples projeto CRUD utilizando o acesso a banco de dados com o MySQL e linguagem JAVA.

Configuração do Projeto:

Executar a query dados.sql ou importar o arquivo no phpMyAdmin para criar a table necessária.

Editar o arquivo ClienteDAO.java
Linha 23:       conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dados", "root", "");
