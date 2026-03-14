CREATE TRIGGER before_user_insert 
BEFORE INSERT ON users 
FOR EACH ROW SET NEW.created_at = NOW();
