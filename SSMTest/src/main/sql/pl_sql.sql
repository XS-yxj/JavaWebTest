-- 关注与取消关注存储过程
DELIMITER $$

CREATE PROCEDURE `ssm`.`watch`
  (in name_a varchar(50), in name_b varchar(50),
   out w_result int)
  BEGIN
    DECLARE a_count int DEFAULT 0;
    START TRANSACTION ;
    insert ignore into friend(user_a, user_b)
    values(name_a, name_b);
    select row_count() into a_count;
    IF (a_count = 1) THEN
      set w_result = 1 ;
    ELSE
      delete from friend
      where user_a = name_a and user_b = name_b;
      set w_result = -1;
    END IF;
    COMMIT ;
  END;
$$

DELIMITER ;

set @w_result = 0;

call watch("admin", "孤世", @w_result);

select @w_result
