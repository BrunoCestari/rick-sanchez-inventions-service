DROP TABLE IF EXISTS inventions;


CREATE TABLE inventions (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  description TEXT,
  name VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL
);

INSERT INTO inventions (name, category, description, price, created_at) VALUES
('Space Cruiser', 'Vehicle', 'Rick''s space cruiser is a flying vehicle (especially car) created by Rick. Rick pieced the ship together from materials found in the garage of the Smith Residence. The ship is shaped like a UFO and features wheels on the underside for landings. The interior of the ship is commonly full of empty bottles of alcohol.', 1500000, CURRENT_TIMESTAMP)

