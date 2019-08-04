-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作证-论文', '3', '1', '/system/docManagePaper', 'C', '0', 'system:docManagePaper:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '作证-论文菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作证-论文查询', @parentId, '1',  '#',  'F', '0', 'system:docManagePaper:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作证-论文新增', @parentId, '2',  '#',  'F', '0', 'system:docManagePaper:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作证-论文修改', @parentId, '3',  '#',  'F', '0', 'system:docManagePaper:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作证-论文删除', @parentId, '4',  '#',  'F', '0', 'system:docManagePaper:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
