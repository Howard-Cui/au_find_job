drop table if exists `find_job_au`;

create database if not exists `find_job_au`;

use `find_job_au`;

create table `position` (
                            `id` bigint unsigned not null auto_increment,
                            `title` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '职位',
                            `salary` varchar(45) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '薪水',
                            `describe` text character set utf8mb4 collate utf8mb4_unicode_ci not null comment '工作内容介绍',
                            `base_id` bigint unsigned not null,
                            `company` varchar(200) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '工作',
                            `img_sets` varchar(3000) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '多个图片url',
                            `tag_sets` varchar(300) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '多个tags的名称',
                            `create_time` int unsigned not null,
                            `update_time` int unsigned not null,
                            `is_deleted` tinyint unsigned not null default '0',
                            primary key(`id`),
                            index uk_base_id (`base_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_unicode_ci comment 	'工作岗位';

create table `base` (
                        `id` bigint unsigned not null auto_increment,
                        `base_city` varchar(45) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '城市',
                        `base_state` varchar(3) character set utf8mb4 collate utf8mb4_unicode_ci not null comment '州',
                        `create_time` int unsigned not null,
                        `update_time` int unsigned not null,
                        `is_deleted` tinyint unsigned not null default '0',
                        primary key(`id`)
)engine=InnoDB default charset=utf8mb4 collate=utf8mb4_unicode_ci comment '工作地点';