CREATE TABLE pet_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pet_id INT NOT NULL,
    temperament VARCHAR(255),
    length DOUBLE,
    weight DOUBLE,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);
