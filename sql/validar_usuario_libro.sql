CREATE TRIGGER `validar_usuario_libro` AFTER INSERT ON `libro`
 FOR EACH ROW IF NEW.id_usuario IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Advertencia: El libro no tiene usuario asignado.';
    END IF
