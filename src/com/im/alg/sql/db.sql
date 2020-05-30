
-- 1. 查询课程编号为1的课程比课程编号为2的课程分数高的学生信息和分数(重点)
/**
    问题拆分,利用子查询
    构建一个中间表带有学生id, 课程1分数,课程2分数的表,

 */
select s.*,a.sc_score,b.sc_score from (
                                  select sc_Id, sc_score
                                  from score
                                  where sc_cid = 1
                              ) as a
                                  inner join (
    select sc_Id ,sc_score from score where sc_cid = 2) as b
                                             on a.sc_Id = b.sc_Id
inner join student s on s.stu_id = a.sc_Id
where a.sc_score > b.sc_score;

-- 2. 查询平均成绩大于60分的学生的学号和平均成绩
select sc_Id "学生ID",avg(sc_score) "平均成绩" from score
 group by sc_Id having avg(sc_score) > 60;


-- 3. 查询所有学生的学号,姓名,选课数,总成绩
 /**
   要考虑到没有选课的学生
  */
select s.stu_id,s.stu_name,count(sc.sc_cid),
       sum(case when sc.sc_score is null then 0 else sc.sc_score end)
from student s left join score sc
on s.stu_id = sc.s_Id  group by s.stu_id,s.stu_name

-- 4. 查询姓吴的老师个数
/**
        如查老师名字需要去重 换成  count(distinct t_name)
 */
select count(t_id)
from teacher  where t_name like "张%";

-- 5. 查询没有学过张三老师课程的学生学号和姓名(重点)
/**
    查出学生选择张三老师讲的课程编号的学生id 然后排除

 */
select stu_id,stu_name from student
where stu_id not in
      (
          select sc.s_Id
          from score sc
                   inner join course c on sc.sc_cid = c.c_id
                   inner join teacher t on c.t_id = t.t_id
          where t.t_name = "张三"
      );

-- 6. 查询学过张三老师所教的所有课程的同学的学号,姓名(重点)

select s.stu_id "学号", s.stu_name "姓名" from student s
where s.stu_id in (
        select  sc.s_Id from score sc
    inner join course c on sc.sc_cid = c.c_id
    inner join teacher t on c.t_id = t.t_id where t_name = "张三"
    );

-- 7. 查询学过编号为1的课程并且也学过编号为2的课程的学生学号和姓名(重点)

select stu_id,stu_name from student where stu_id
in (
                               select a.s_Id
                                from (
                                          (select * from score a where a.sc_cid = 1) a
                                         inner join
                                    ( select *  from score b where b.sc_cid = 2 ) b
                                        on a.s_Id = b.s_Id
                                    )
                            );

-- 8. 查询02课程的总成绩
select sum(sc_score) from score group by sc_cid having sc_cid =2;

-- 9. 查询所有课程成绩小于60分的学生的学号,姓名

select distinct st.stu_id,st.stu_name from student st left join score sc
on st.stu_id = sc.s_Id
where sc.sc_score < 60 or sc.s_Id is null;

-- 10. 查询没有学全所有课程的学生学号和姓名(重点)

select st.stu_id,st.stu_name from student st left join score sc
on st.stu_id = sc.s_Id  group by st.stu_id, st.stu_name
having count(sc.sc_cid) < (select count(c_id) from course);


