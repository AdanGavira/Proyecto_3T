CREATE TRIGGER `actualizar_fecha_nacimiento` BEFORE UPDATE ON `usuario`
 FOR EACH ROW IF NEW.fecha_de_nacimiento IS NULL THEN
        SET NEW.fecha_de_nacimiento = CURDATE();
    END IF