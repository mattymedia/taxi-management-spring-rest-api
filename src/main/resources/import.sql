INSERT INTO roles(role_name, role_details) VALUES('ROLE_ADMIN', 'Rol de usuario con permisos especiales. Control total de la aplicacion'), ('ROLE_USER', 'Rol de usuario con permisos basicos. Puede cambiar su informacion basica y solicitar documentacion (Liquidacion laboral, certificado laboral)');

INSERT INTO vehicles(registration, model, brand) VALUES('TGT042', '2015', 'Chevrolet');
INSERT INTO vehicles(registration, model, brand) VALUES('TGL117', '2012', 'Hyundai');

INSERT INTO users(username, password, create_at) VALUES('admin', 'admin01', '2023-03-01');
INSERT INTO users(username, password, create_at) VALUES('maikol', 'maikol01', '2023-03-01');
INSERT INTO users(username, password, create_at) VALUES('fabian', 'fabian01', '2023-03-01');
INSERT INTO users(username, password, create_at) VALUES('jhon', 'jhon01', '2023-03-01');

INSERT INTO role_user(user_id, role_id) values(1,1), (1,2), (2,2), (3,2), (4,2);

INSERT INTO user_profile(id_card, name, surname, email, birth_date, phone_number, residence_address) VALUES(1110, 'michael', 'garzon', 'maikol@email.com', '1989-11-19', '3224256789', 'calle 13 nro. 13-25');

UPDATE users SET profile_id = 1 WHERE id = 2;

INSERT INTO vehicle_assignments(user_id, vehicle_id, assignment_date) VALUES(2,1, CURRENT_TIMESTAMP), (3,2, CURRENT_TIMESTAMP);

INSERT INTO daily_reports(vehicle_assignment_id, daily_fee_received, report_detail, report_date) VALUES(1, 100000, 'Ningun Inconveniente', CURRENT_TIMESTAMP);

INSERT INTO vechicle_mro(vehicle_id, detail_mro, realization_date, current_mileage) VALUES(1, 'revision motor', CURRENT_TIMESTAMP, 532621);
INSERT INTO vechicle_mro(vehicle_id, detail_mro, realization_date, current_mileage) VALUES(2, 'revision Tanque gasolina', CURRENT_TIMESTAMP, 532621);
