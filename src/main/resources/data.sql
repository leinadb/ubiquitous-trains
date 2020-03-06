INSERT INTO user (id, name, password, email, full_name) VALUES
  ('1b21ca16-ea24-462d-84be-2d2eff35d168','daniel', 'password', 'daniel@daniel.pl', 'daniel b.'),
  ('2d963138-2477-48fd-b8ae-1efc48c63358','tero', 'password', 'tero@tero.fi', 'tero r.');

INSERT INTO role (id, name) VALUES
  ('8efd256b-aa2a-4fcf-8e21-0fb6ad1c71ca','ROLE_USER'),
  ('5805fb4c-220d-4514-b121-9384f93dd00b','ROLE_SUPER_USER');

INSERT INTO users_roles (user_id, role_id) VALUES
  ('2d963138-2477-48fd-b8ae-1efc48c63358', '8efd256b-aa2a-4fcf-8e21-0fb6ad1c71ca'),
  ('1b21ca16-ea24-462d-84be-2d2eff35d168', '8efd256b-aa2a-4fcf-8e21-0fb6ad1c71ca'),
  ('2d963138-2477-48fd-b8ae-1efc48c63358', '5805fb4c-220d-4514-b121-9384f93dd00b');