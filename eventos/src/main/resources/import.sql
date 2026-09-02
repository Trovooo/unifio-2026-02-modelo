INSERT INTO categoria (name, description) VALUES ('Tecnologia', 'Workshops e palestras sobre desenvolvimento de software e inovação');
INSERT INTO categoria (name, description) VALUES ('Design', 'Sessões voltadas para UI/UX, design gráfico e experiência do usuário');
INSERT INTO categoria (name, description) VALUES ('Negócios', 'Painéis sobre empreendedorismo, startups e gestão de empresas');
INSERT INTO categoria (name, description) VALUES ('Carreira', 'Dicas de mercado de trabalho, mentoria e desenvolvimento profissional');
INSERT INTO categoria (name, description) VALUES ('Games', 'Discussões sobre desenvolvimento de jogos, eSports e arte 3D');

INSERT INTO local (name, endereco, space) VALUES ('Auditório Principal', 'Av. Luiz Saldanha Rodrigues, 1500', 350);
INSERT INTO local (name, endereco, space) VALUES ('Laboratório de Informática 1', 'Rua Arnaldo Pescatori, 220', 40);
INSERT INTO local (name, endereco, space) VALUES ('Centro de Convenções', 'Rua Antonio Prado, 85', 1000);
INSERT INTO local (name, endereco, space) VALUES ('Espaço Maker', 'Rua Duque de Caxias, 410', 60);
INSERT INTO local (name, endereco, space) VALUES ('Sala de Treinamento B', 'Av. Altino Arantes, 300', 80);

INSERT INTO participante (name, email, telephone) VALUES ('Felipe Bertoldo', 'felipe.bertoldo@gmail.com', '14998112233');
INSERT INTO participante (name, email, telephone) VALUES ('Ana Lívia', 'ana.caprioli@gmail.com', '14997445566');
INSERT INTO participante (name, email, telephone) VALUES ('Kauan Silva', 'kauan.silva@gmail.com', '14996778899');
INSERT INTO participante (name, email, telephone) VALUES ('Nicolly Marques', 'nicolly.sene@gmail.com', '14991223344');
INSERT INTO participante (name, email, telephone) VALUES ('Mauricio Gandolfo', 'mauricio.g@gmail.com', '14995556677');

INSERT INTO palestrante (name, mini_bio, email) VALUES ('Professor Mateus', 'Especialista em Banco de Dados e Engenharia de Software', 'mateus.prof@unifio.edu.br');
INSERT INTO palestrante (name, mini_bio, email) VALUES ('Mariana Costa', 'Líder de Design de Produto e especialista em UX Research', 'mariana.costa@tech.com');
INSERT INTO palestrante (name, mini_bio, email) VALUES ('Carlos Eduardo', 'Desenvolvedor Senior Java e Arquiteto de Soluções Cloud', 'carlos.eduardo@dev.io');
INSERT INTO palestrante (name, mini_bio, email) VALUES ('Beatriz Lima', 'Consultora de Agilidade e Gestão de Projetos Tecnológicos', 'beatriz.lima@agile.org');
INSERT INTO palestrante (name, mini_bio, email) VALUES ('Lucas Andrade', 'Engenheiro de Inteligência Artificial e Ciência de Dados', 'lucas.andrade@ai.com');

INSERT INTO evento (nome, descricao, data_inicio, data_fim, capacidade, status, categoria_id, local_id, palestrante_id) VALUES ('Workshop de Java & Spring Boot', 'Curso prático de criação de APIs RESTful', '2026-10-20', '2026-10-21', 40, 'AGENDADO', 2, 3, 4);
INSERT INTO evento (nome, descricao, data_inicio, data_fim, capacidade, status, categoria_id, local_id, palestrante_id) VALUES ('UI/UX Design Masterclass', 'Aprenda a prototipar interfaces do zero ao avançado', '2026-11-05', '2026-11-05', 60, 'AGENDADO', 3, 5, 3);
INSERT INTO evento (nome, descricao, data_inicio, data_fim, capacidade, status, categoria_id, local_id, palestrante_id) VALUES ('Semana da Engenharia de Software', 'Palestras com profissionais do mercado sobre arquitetura de software', '2026-11-10', '2026-11-14', 350, 'AGENDADO', 2, 2, 2);
INSERT INTO evento (nome, descricao, data_inicio, data_fim, capacidade, status, categoria_id, local_id, palestrante_id) VALUES ('Metodologias Ágeis na Prática', 'Como aplicar Scrum e Kanban em projetos de tecnologia', '2026-12-01', '2026-12-01', 80, 'AGENDADO', 5, 1, 5);
INSERT INTO evento (nome, descricao, data_inicio, data_fim, capacidade, status, categoria_id, local_id, palestrante_id) VALUES ('Game Dev Summit', 'Desenvolvimento de jogos independentes e modelagem 3D', '2026-12-10', '2026-12-12', 200, 'AGENDADO', 4, 4, 1);

INSERT INTO inscricao (data_inscricao, status, evento_id, participante_id) VALUES ('2026-09-02', 'CONFIRMADA', 2, 2);
INSERT INTO inscricao (data_inscricao, status, evento_id, participante_id) VALUES ('2026-09-02', 'CONFIRMADA', 2, 3);
INSERT INTO inscricao (data_inscricao, status, evento_id, participante_id) VALUES ('2026-09-03', 'PENDENTE', 3, 4);
INSERT INTO inscricao (data_inscricao, status, evento_id, participante_id) VALUES ('2026-09-04', 'CONFIRMADA', 4, 5);
INSERT INTO inscricao (data_inscricao, status, evento_id, participante_id) VALUES ('2026-09-05', 'CANCELADA', 1, 1);