INSERT INTO kpacs (id, title, description, creation_date) VALUES (1, 'K-PAC 1', 'Description for K-PAC 1', '2024-05-22');
INSERT INTO kpacs (id, title, description, creation_date) VALUES (2, 'K-PAC 2', 'Description for K-PAC 2', '2024-05-22');
INSERT INTO kpac_sets (id, title) VALUES (1, 'K-PAC Set 1');
INSERT INTO kpac_sets (id, title) VALUES (2, 'K-PAC Set 2');
INSERT INTO kpac_set_kpac (set_id, kpac_id) VALUES (1, 1);
INSERT INTO kpac_set_kpac (set_id, kpac_id) VALUES (1, 2);
INSERT INTO kpac_set_kpac (set_id, kpac_id) VALUES (2, 2);
