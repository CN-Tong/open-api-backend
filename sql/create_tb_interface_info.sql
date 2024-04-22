-- open_api_db.`interface_info`
create table if not exists open_api_db.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '接口名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `method` varchar(256) not null comment '请求类型',
    `request_header` text null comment '请求头',
    `response_header` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0 - 关闭 1 - 开启）',
    `user_id` bigint not null comment '创建用户id',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment 'open_api_db.`interface_info`';

insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('龙琪', 'EU7S0', 'www.devon-okon.name', '任展鹏', '萧锦程', '何鹏飞', 0, 198);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('马钰轩', '0Z', 'www.chester-boyle.name', '朱浩轩', '董越彬', '杨荣轩', 0, 4113348828);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('雷旭尧', '53x', 'www.hallie-weissnat.co', '白博超', '蒋航', '侯子默', 0, 52068);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('范健柏', 'Jewuz', 'www.beata-brown.org', '郑伟诚', '莫鸿煊', '邓立果', 0, 571);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('陆煜城', 'm6Nj', 'www.tequila-dicki.biz', '江明哲', '戴靖琪', '王耀杰', 0, 6535050);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('侯越彬', 'iRDID', 'www.valentin-mueller.co', '罗懿轩', '曹煜城', '萧乐驹', 0, 808521126);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('邹金鑫', 'ySv8v', 'www.wes-dickinson.name', '谭风华', '秦文轩', '金浩然', 0, 26982);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('郭天翊', 'Ylk', 'www.tom-medhurst.io', '何风华', '苏涛', '程雨泽', 0, 854);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('黄志强', 'AXJ', 'www.minh-jaskolski.net', '武鑫鹏', '武晓啸', '马彬', 0, 678623216);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('程昊然', 'hueu', 'www.hoyt-wehner.com', '段烨华', '邵绍辉', '侯思源', 0, 4);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('傅熠彤', 'qwR', 'www.tyrell-bruen.biz', '黄子骞', '韩天翊', '黄昊强', 0, 6690918626);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('田钰轩', 'he', 'www.santina-mclaughlin.biz', '方文', '雷立辉', '傅浩', 0, 653371);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('吕绍齐', '7aqI', 'www.lane-west.org', '郝博涛', '邱博涛', '吕浩然', 0, 79);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('雷航', 'xRj9R', 'www.jimmie-brekke.co', '朱乐驹', '朱文昊', '丁晓博', 0, 82524);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('余鸿涛', 'SNSHb', 'www.bobby-lang.name', '郭浩宇', '龙胤祥', '余健雄', 0, 4860794254);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('万子涵', 'TavlY', 'www.patience-welch.info', '胡哲瀚', '冯思淼', '洪文', 0, 52706733);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('金晋鹏', '9U', 'www.cathryn-ward.name', '曾伟诚', '陶振家', '周浩然', 0, 75451);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('邹黎昕', 'JTHx', 'www.ellsworth-leuschke.io', '苏旭尧', '陶楷瑞', '郭烨霖', 0, 745);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('袁立轩', 'dv', 'www.lina-carter.net', '覃正豪', '金俊驰', '郝昊强', 0, 554811903);
insert into open_api_db.`interface_info` (`name`, `description`, `url`, `method`, `request_header`, `response_header`, `status`, `user_id`) values ('陈绍齐', '3VD', 'www.milagro-zulauf.org', '毛文轩', '方俊驰', '武皓轩', 0, 33798528);