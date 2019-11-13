# Aplicação Desenvolvida com Spring Boot

# Para executar aplicação é necessário ter Gradle configurado

# Na pasta Docs está o schema do banco em MySql 5.7

# Na pasta Docs também consta arquivo json do Postman com chamadas rest, basta importar para o Postman




# Ciclo para Teste:


# Cria associado		

POST http://localhost:8080/api/v1/associados
{
	"nome" : "nome",
	"cpf" : "404.517.580-64",
	"email" : "nome@dominio.com"
}

# Cria pauta

POST http://localhost:8080/api/v1/pautas
{
	"titulo" : "titulo da pauta",
	"tempo" : 60
}


# Inicia Se��o da Pauta

GET http://localhost:8080/api/v1/pautas/inicia/2
{
	"titulo" : "titulo",
	"tempo" : 10
}

# Vota

POST http://localhost:8080/api/v1/votos
{
	"pauta_id": 4,
	"associado_id": 4,
	"voto": true
}


# Encerra se��o, contabiliza votos e envia para mensageria

GET http://localhost:8080/api/v1/pautas/encerra/2







