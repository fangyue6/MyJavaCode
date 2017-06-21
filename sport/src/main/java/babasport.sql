/*创建品牌表 : bbs_brand*/
DROP TABLE IF EXISTS `bbs_brand`;
CREATE TABLE `bbs_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `description` varchar(80) DEFAULT NULL COMMENT '描述',
  `img_url` varchar(80) DEFAULT NULL COMMENT '图片Url',
  `web_site` varchar(80) DEFAULT NULL COMMENT '品牌网址',
  `sort` int(11) DEFAULT NULL COMMENT '排序:最大最排前',
  `is_display` tinyint(1) DEFAULT NULL COMMENT '是否可见 1:可见 0:不可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='品牌';


/*导入测试数据*/
INSERT INTO bbs_brand VALUES ('1', '依琦莲', null, null, null, '99', '1');
INSERT INTO bbs_brand VALUES ('2', '凯速（KANSOON）', null, null, null, 98, '1');
INSERT INTO bbs_brand VALUES ('3', '梵歌纳（vangona）', null, null, null, 97, '1');
INSERT INTO bbs_brand VALUES ('4', '伊朵莲', null, null, null, 96, '1');
INSERT INTO bbs_brand VALUES ('5', '菩媞', null, null, null, 95, '1');
INSERT INTO bbs_brand VALUES ('6', '丹璐斯', null, null, null, 94, '1');
INSERT INTO bbs_brand VALUES ('7', '喜悦瑜伽', null, null, null, 93, '1');
INSERT INTO bbs_brand VALUES ('8', '皮尔（pieryoga）', null, null, null, 92, '1');
INSERT INTO bbs_brand VALUES ('9', '路伊梵（LEFAN）', null, null, null, 91, '1');
INSERT INTO bbs_brand VALUES ('10', '金啦啦', null, null, null, 90, '0');
INSERT INTO bbs_brand VALUES ('11', '来尔瑜伽（LaiErYoGA）', null, null, null, 89, '1');
INSERT INTO bbs_brand VALUES ('12', '艾米达（aimida）', null, null, null, 88, '1');
INSERT INTO bbs_brand VALUES ('13', '斯泊恩', null, null, null, 87, '1');
INSERT INTO bbs_brand VALUES ('14', '康愫雅KSUA', null, null, null, 86, '1');
INSERT INTO bbs_brand VALUES ('15', '格宁', null, null, null, 85, '1');
INSERT INTO bbs_brand VALUES ('16', 'E奈尔（Enaier）', null, null, null, 84, '1');
INSERT INTO bbs_brand VALUES ('17', '哈他', null, null, null, 83, '1');
INSERT INTO bbs_brand VALUES ('18', '伽美斯（Jamars）', null, null, null, 82, '1');
INSERT INTO bbs_brand VALUES ('19', '瑜伽树（yogatree）', null, null, null, 81, '1');
INSERT INTO bbs_brand VALUES ('20', '兰博伊人（lanboyiren）', null, null, null, 80, '1');




