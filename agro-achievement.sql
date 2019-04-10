/*
 Navicat Premium Data Transfer

 Source Server         : hyx
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 119.23.10.167:3306
 Source Schema         : agro-achievement

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 06/04/2019 15:52:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `achievement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `achievement_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果名称',
  `achievement_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '成果简介',
  `achievement_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果关键词',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '研发开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '研发结束时间',
  `picture_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品图片展示（1到3张）',
  `awards` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '获奖情况',
  `linkman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `cell_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `contact_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `property_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '知识产权编号',
  `property_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '知识产权说明',
  `property_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权归属者',
  `property_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权归属地',
  `expected_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预期交易价格（万元）',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `page_view` int(11) NULL DEFAULT NULL COMMENT '点击量',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态码（0未审核，1通过，2失败）',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`achievement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES (21, '结果反馈', '阿诗丹顿', 'sad', '2019-02-20 16:00:00', '2019-03-08 16:00:00', '/upload/2951920190219.jpeg', '阿萨德', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '阿达', '1', '山西省', '1500', '2019-02-19 11:46:50', 1222, 1, '1', '农产品与食品加工');
INSERT INTO `achievement` VALUES (22, '结果反馈', '阿诗丹顿', 'sad', '2019-02-20 16:00:00', '2019-03-08 16:00:00', '/upload/1624820190219.jpg,', '阿萨德', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '阿达', NULL, '湖北省', '1500', '2019-02-19 11:47:47', 0, 2, '2', '养殖');
INSERT INTO `achievement` VALUES (23, '结果反馈', '奥术大师多', '电风扇', '2019-02-18 16:00:00', '2019-03-08 16:00:00', '/upload/9996320190219.jpg', '阿打算', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '阿萨德', NULL, '辽宁省', '1500', '2019-02-19 11:49:05', 23, 3, '0', '种业');
INSERT INTO `achievement` VALUES (24, '结果反馈', '对方过后的', 'GJ', '2019-02-18 16:00:00', '2019-03-08 16:00:00', '/upload/3982920190219.jpg,', '梵蒂冈和', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '烦得很', NULL, '湖南省', '1500', '2019-02-19 12:28:43', 0, 2, '0', '养殖');
INSERT INTO `achievement` VALUES (55, '小麦', '小麦', '双方都', '2019-03-04 16:00:00', '2019-03-04 16:00:00', '/upload/9872920190329.jpg,', 'sad', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '阿达', NULL, '湖南省', '1500万元万元', '2019-03-29 09:31:27', 0, 3, '0', '种植,种植');
INSERT INTO `achievement` VALUES (56, '苹果', '苹果大丰收', '苹果', '2019-04-02 16:00:00', '2019-04-29 16:00:00', '/upload/7633120190403.jpeg', '省一等奖', '王静晓', '15936518121', '15936518126', '2962784371@qq.com', '1500', '12', '所属王静晓', NULL, '湖北省', '10000', '2019-04-03 08:55:55', 12221, 3, '1', '种植');
INSERT INTO `achievement` VALUES (57, '草莓', '草莓', '草莓', '2019-04-26 16:00:00', '2019-04-29 16:00:00', '/upload/5612320190403.jpg,', '省二', '王静晓', '15936518126', '15936518126', '2962784374@qq.com', '1500', '521', '棒', NULL, '湖南省', '15200', '2019-04-03 09:06:15', 0, 3, '0', '种业');
INSERT INTO `achievement` VALUES (58, '瞒过', '瞒过', '瞒过', '2019-03-31 16:00:00', '2019-04-02 16:00:00', '/upload/2621620190403.jpeg,', '省二', '王静晓', '15936518126', '15936518126', '2962784374@qq.com', '1500', '12', '暂无', NULL, '河南省', '1523', '2019-04-03 09:13:53', 0, 3, '0', '种业');
INSERT INTO `achievement` VALUES (59, '励志', '励志', '励志', '2019-03-31 16:00:00', '2019-03-31 16:00:00', '/upload/4411620190403.jpeg,/upload/9108220190403.jpg,', '省二', '王静晓', '15936518126', '15936518126', '2962784374@qq.com', '1500', '12', '暂无', NULL, '河南省', '1523万元', '2019-04-03 09:15:37', 0, 3, '0', '种植,种植');
INSERT INTO `achievement` VALUES (60, '发给', '发给', '发给', '2019-03-30 16:00:00', '2019-04-02 16:00:00', '/upload/2227920190403.jpg,', '发给', '发给', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'JGJG', '分', NULL, '河北省', '1523', '2019-04-03 09:16:46', 0, 3, '0', '种植');
INSERT INTO `achievement` VALUES (63, '啊', '去', '啊', '2017-04-11 16:00:00', '2019-04-02 16:00:00', '/upload/3586820190403.jpg,', '1', '王冰', '13598212954', '13598212954', '2498584007@qq.com', '河南', '1', '1', '1', '山东省', '121', '2019-04-03 12:38:21', 12, 1, '1', '养殖');
INSERT INTO `achievement` VALUES (64, '啊', '的份上', '啊', '2017-04-10 16:00:00', '2019-04-02 16:00:00', '/upload/4441920190403.jpg,/upload/7992520190403.jpg,', '1', '王冰', '13598212954', '13598212954', '2498584007@qq.com', '河南', '1', '1', '1', '湖北省', '121', '2019-04-03 12:47:55', 12, 1, '1', '种植');
INSERT INTO `achievement` VALUES (65, '好好学习', '好好学习天天向上', '学习', '2018-04-11 16:00:00', '2019-04-02 16:00:00', '/upload/6219220190403.jpg,', '2', '臭居居', '15936571965', '13598212954', '2498584007@qq.com', '河南', '2', '1', '2', '河南省', '121', '2019-04-03 12:51:21', 999999, 1, '1', '臭居居');
INSERT INTO `achievement` VALUES (66, '123', '阿萨德', '双方都', '2019-04-02 16:00:00', '2019-04-16 16:00:00', '/upload/4326520190403.jpg,', '阿萨德', '水电费', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '阿萨德', NULL, '天津市', '1500', '2019-04-03 12:59:50', 0, 3, '0', '种业');
INSERT INTO `achievement` VALUES (67, '结果反馈', '东方闪电', '双方都', '2019-04-03 16:00:00', '2019-04-03 16:00:00', '/upload/2731020190404.jpg,', '在不再续', '发斯蒂芬', '15936518126', '15936518126', '2962784374@qq.com', '1500', 'SF', '只需向', NULL, '山西省', '1500', '2019-04-04 14:16:29', 0, 3, '0', '农业、农村信息化');

-- ----------------------------
-- Table structure for achievement_type
-- ----------------------------
DROP TABLE IF EXISTS `achievement_type`;
CREATE TABLE `achievement_type`  (
  `achievement_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `achievement_id` int(11) NULL DEFAULT NULL COMMENT '成果编号id',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`achievement_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of achievement_type
-- ----------------------------
INSERT INTO `achievement_type` VALUES (1, NULL, 1);
INSERT INTO `achievement_type` VALUES (2, NULL, 4);
INSERT INTO `achievement_type` VALUES (3, NULL, 4);
INSERT INTO `achievement_type` VALUES (4, NULL, 4);
INSERT INTO `achievement_type` VALUES (5, NULL, 4);
INSERT INTO `achievement_type` VALUES (6, NULL, 4);
INSERT INTO `achievement_type` VALUES (7, NULL, 4);
INSERT INTO `achievement_type` VALUES (8, NULL, 1);
INSERT INTO `achievement_type` VALUES (9, NULL, 4);
INSERT INTO `achievement_type` VALUES (10, NULL, 3);
INSERT INTO `achievement_type` VALUES (11, NULL, 9);
INSERT INTO `achievement_type` VALUES (12, NULL, 2);
INSERT INTO `achievement_type` VALUES (13, NULL, 1);
INSERT INTO `achievement_type` VALUES (14, NULL, 3);
INSERT INTO `achievement_type` VALUES (15, NULL, 3);
INSERT INTO `achievement_type` VALUES (16, NULL, 1);
INSERT INTO `achievement_type` VALUES (17, NULL, 3);
INSERT INTO `achievement_type` VALUES (18, NULL, 3);
INSERT INTO `achievement_type` VALUES (19, NULL, 8);
INSERT INTO `achievement_type` VALUES (20, NULL, 6);
INSERT INTO `achievement_type` VALUES (21, NULL, 4);
INSERT INTO `achievement_type` VALUES (22, NULL, 7);
INSERT INTO `achievement_type` VALUES (23, NULL, 1);
INSERT INTO `achievement_type` VALUES (24, NULL, 5);
INSERT INTO `achievement_type` VALUES (25, NULL, 5);
INSERT INTO `achievement_type` VALUES (26, NULL, 5);
INSERT INTO `achievement_type` VALUES (27, NULL, 5);
INSERT INTO `achievement_type` VALUES (28, NULL, 5);
INSERT INTO `achievement_type` VALUES (29, NULL, 1);
INSERT INTO `achievement_type` VALUES (30, NULL, 1);
INSERT INTO `achievement_type` VALUES (31, NULL, 1);
INSERT INTO `achievement_type` VALUES (32, NULL, 1);
INSERT INTO `achievement_type` VALUES (33, NULL, 1);
INSERT INTO `achievement_type` VALUES (34, NULL, 1);
INSERT INTO `achievement_type` VALUES (35, NULL, 1);
INSERT INTO `achievement_type` VALUES (36, NULL, 1);
INSERT INTO `achievement_type` VALUES (37, NULL, 1);
INSERT INTO `achievement_type` VALUES (38, NULL, 1);
INSERT INTO `achievement_type` VALUES (39, NULL, 1);
INSERT INTO `achievement_type` VALUES (40, NULL, 1);
INSERT INTO `achievement_type` VALUES (41, NULL, 1);
INSERT INTO `achievement_type` VALUES (42, NULL, 8);
INSERT INTO `achievement_type` VALUES (43, NULL, 8);
INSERT INTO `achievement_type` VALUES (44, NULL, 8);
INSERT INTO `achievement_type` VALUES (45, NULL, 8);
INSERT INTO `achievement_type` VALUES (46, NULL, 3);
INSERT INTO `achievement_type` VALUES (47, NULL, 2);
INSERT INTO `achievement_type` VALUES (48, NULL, 2);
INSERT INTO `achievement_type` VALUES (49, NULL, 6);
INSERT INTO `achievement_type` VALUES (50, NULL, 2);
INSERT INTO `achievement_type` VALUES (51, NULL, 2);
INSERT INTO `achievement_type` VALUES (52, NULL, 1);
INSERT INTO `achievement_type` VALUES (53, NULL, 1);
INSERT INTO `achievement_type` VALUES (54, NULL, 2);
INSERT INTO `achievement_type` VALUES (55, NULL, 2);
INSERT INTO `achievement_type` VALUES (56, NULL, 1);
INSERT INTO `achievement_type` VALUES (57, NULL, 2);
INSERT INTO `achievement_type` VALUES (58, NULL, 3);
INSERT INTO `achievement_type` VALUES (59, NULL, 1);
INSERT INTO `achievement_type` VALUES (60, NULL, 3);
INSERT INTO `achievement_type` VALUES (61, NULL, 2);
INSERT INTO `achievement_type` VALUES (62, NULL, 14);
INSERT INTO `achievement_type` VALUES (63, NULL, 1);
INSERT INTO `achievement_type` VALUES (64, NULL, 9);

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `announcement_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `announcement_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `announcement_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告类型（新闻中心，交易活动）',
  PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '科技部 鼓励支持民营企业参与国家重大科技任务', '科技部部长王志刚6日表示，科技部将鼓励支持民营企业参与国家重大科技任务，充分发挥民营企业机制体制灵活、市场敏感度高等特点，推动高校和科研院所成果在民营企业转移转化，加快形成具有市场竞争力的产品。\n\n“民营经济是我国经济发展的重要组成部分，鼓励支持民营科技企业的发展始终是科技工作者的重要内容。”王志刚在当天召开的第十二届中国产学研合作创新大会上说，科技部将加快构建以企业为主体、市场为导向、产学研深度融合的技术创新体系，进一步优化创新创业生态，为民营企业营造公平竞争的创新环境和市场环境。\n\n同时，支持民营企业加大科技投入，充分利用好各类政策工具，采取前期资金投入、后期补助等方式，对民营企业竞争前技术研发给予扶持，鼓励有能力的民营企业探索前沿无人区。完善科技金融体系，强化对民营科技企业创新创业成长阶段的资金支持，缓解高成长性企业可能面临的融资难、融资贵的问题。\n\n此外，科技部还将加大民营企业创新人才培养力度，畅通从高校、科研院所到民营高科技企业的人才流动机制，让优秀科技人才在民营企业能够留得住。研究支持科技型中小企业技术人才培养的政策措施，鼓励更多的科技人员带着科技成果到市场上创业，培育更多新的技术集群和产业增长点。\n\n来源: 新华社', '2019-01-25 02:59:49', '新闻中心');
INSERT INTO `announcement` VALUES (2, '国办发文推动相关政策落实 赋予科研人员更大自主权', '国务院办公厅日前印发关于抓好赋予科研机构和人员更大自主权有关文件贯彻落实工作的通知，要求各地区、各部门、各单位充分认识赋予科研机构和人员自主权的重要意义，制定政策落实的配套制度和具体实施办法，相关工作要在2019年2月底前完成。\n\n赋予科研单位和科研人员更大自主权、切实减轻科研人员负担，对于调动科研人员积极性、充分释放创新创造活力具有重要意义。\n\n通知指出，近年来，党中央、国务院聚焦完善科研管理、提升科研绩效、推进成果转化、优化分配机制等方面，先后制定出台了一系列政策文件，受到广大科技工作者的拥护和欢迎。但在落实过程中还不同程度存在各类问题，制约了政策效果。有的部门、地方以及科研单位没有及时修订本部门、本地方和本单位的科研管理相关制度规定，仍然按照老办法来操作；有的经费调剂使用、仪器设备采购等仍然由相关机构管理，没有落实到项目承担单位；科技成果转化、薪酬激励、人员流动还受到相关规定的约束等。\n\n通知明确，对党中央、国务院已经出台的赋予科研单位和科研人员自主权的有关政策，各地区、各部门和各单位都要制定具体的实施办法，对现行的科研项目、科研资金、科研人员以及因公临时出国等管理办法进行修订，对与新出台政策精神不符的规定要进行清理和修改。各高校、科研院所、国有企业和智库以及其他承担科研任务的单位要按照上述原则修订和制定相关实施办法和制度。\n\n通知要求，深入推进下放科技管理权限工作，推动预算调剂和仪器采购管理权、科研人员的技术路线决策权、项目过程管理权落实到位。科研单位要健全完善内部管理制度。\n\n通知要求，进一步做好已出台法规文件中相关规定的衔接，明确科研人员兼职的操作办法，科研人员获得科技成果转化收益的具体办法，科技成果作为国有资产的管理程序，以及有关项目经费的细化管理制度。\n\n来源: 新华社', '2019-01-25 03:02:53', '新闻中心');
INSERT INTO `announcement` VALUES (3, '科技成果转移转化：拆除阻碍产业化的“篱笆墙”', '作为技术成果走向产业市场的“最后一公里”，科技成果转化一直广受关注。如今的中国科技界，在基础科研领域攻城拔寨、再创佳绩已经不足为奇，科技成果转化能力不强才是我国科技领域存在的突出问题。\n\n自1996年《中华人民共和国促进科技成果转化法》发布以来，我国相继出台了一系列相关政策文件，有效释放了科技成果转化的活力。特别是近日召开的国务院常务会议，再次明确要“强化科技成果转化激励”，并决定将新一批23项改革举措，向更大范围复制推广。\n\n“多项政策改革举措旨在拆除阻碍成果产业化的‘篱笆墙’。”相关学者专家在接受《中国科学报》采访时表示，政策红利的释放，将有助于进一步激发科研人员创新创造的动力和活力，帮助越来越多的科技成果从实验室走向市场。\n\n释放政策红利\n\n尽管科技界对于科技成果转化率的计算一直存在争议，但我国科技成果转化率远低于发达国家却是一个不争的事实。\n\n以美国为例。美国具有较强科研实力的大学和科研单位都设有专门的技术转移机构，并下设研究管理、技术风险、知识产权、商业开发等部门，对研发成果的商业前景、专利代理、转让许可等环节进行跟踪管理。为了加强与企业的联系，美国很多大学和科研单位还与企业建立了合作研究中心，根据企业的技术需求开展课题研究。斯坦福大学首创的“硅谷模式”以及美国国家航空航天局（NASA）的专利转移转化模式，都是成功的典范。\n\n再看以色列，其主要的公立大学、科研机构和大型医院均成立了技术转移公司，通过明确科研人员与技术转移公司的关系、分工及知识产权收益分配奖励机制等，将科技成果转化工作交给相关专业人士，使其转化为市场产品的效率大幅提高。\n\n为此，我国也在借鉴探索一条适合国情的科技成果转移转化道路。2015年以来，我国推动科技成果转移转化的“三部曲”先后问世：2015年10月修订施行的《中华人民共和国促进科技成果转化法》、2016年2月出台的《〈中华人民共和国促进科技成果转化法〉若干规定》以及2016年4月颁布的《促进科技成果转移转化行动方案》。\n\n随着更多的细化举措陆续出台，我国已经初步形成了独具特色的促进科技成果转化的政策法规体系。“2016年国务院文件公布后，知识产权划分变得更清晰。所里也出台了细化的方案，明确了科技成果作价入股的85%奖励给团队，15%所里通过设立投资公司持有，这是以前没有的。”中科院自动化所研究员、中科视语董事长王金桥告诉《中国科学报》，2016年后，知识产权划分、科学家兼职的约束得到松绑，“这非常重要，否则融资都没法谈”。\n\n推动成果落地\n\n“我国科研人员往往把技术藏在实验室里，因为他们不擅长将技术成果推向市场。”国科控股董事长吴乐斌告诉《中国科学报》。\n\n中科院的做法是，实施专项行动“推一把”。2016年，中科院正式启动“促进科技成果转移转化专项行动”。在专项行动的推动下，当年，中科院科技成果转移转化帮助各类企业新增销售收入3831亿元，利税472亿元。其中，中科院科技成果转移转化使12个省份的地方企业当年新增销售收入100亿元以上，使71个地市级的企业当年新增销售收入10亿元以上。\n\n一年后，中科院科技成果转移转化基金正式启动。吴乐斌介绍，基金首期规模预计为30亿至50亿元，将围绕战略新兴产业、结合区域产业布局，设立20至30只子基金，形成200亿元左右的基金总规模。\n\n这些举措均表明中科院推动科技成果转化的决心。以中科院上海硅酸盐所为例，该所为推进项目产出，通过引入资本运作机构、制定以项目完成程度为考核重点的个性化绩效考核政策、采用科研人员离岗创业等模式，同时根据有关政策，制定了《促进科技成果转化暂行办法》等制度，将不低于50%的项目净收益奖励给研发团队。该所的钠镍电池和水系钠离子电池研究团队的成果转移转化均超过5000万元，可分别获2500万元以上奖励。\n\n为促进科技成果转化政策落实、落细、落小，地方政府相关部门也开展了相关行动。以辽宁省为例，记者了解到，辽宁省科技厅会同相关职能部门，选择辽宁省16家不同类型的高校和科研院所，开展科技成果转化相关政策落实试点。比如，辽宁科技大学、辽宁工业大学、辽宁石油化工大学和辽宁省农科院将科技成果转化净收益的80%用来奖励科研人员，沈阳航空航天大学提高到90%，大连工业大学更是提出成果转化收益奖励比例上不封顶。\n\n与市场接轨\n\n如今，已有不少科研人员开始享受到政策红利带来的收益。\n\n2011年，年近八旬的中国工程院院士、北京理工大学教授毛二可带领团队创建了北京理工雷科电子信息技术有限公司（以下简称理工雷科），这也是北京理工大学按照《中关村国家自主创新示范区企业股权和分红激励实施办法》等政策，创办的第一个学科性公司。\n\n毛二可告诉《中国科学报》：“我希望让团队辛苦研发的技术，发挥出更大的社会效益与经济效益。”当年，为支持理工雷科的发展，北京理工大学还将一项发明专利投资于理工雷科，并将该专利所占理工雷科股份的30%（180万元），奖励给毛二可等6名核心技术人员。理工雷科已于2015年成功上市。\n\n对于现行的科技成果转化政策，王金桥等科研人员也提出了一些期望。“希望流程能快一点。”他说，“比如，涉及到所办企业的知识产权评估需要上报审批流程，办下来可能得三个月左右，如果一个纯民营的机构去做，可能两三周就搞定。”\n\n王金桥告诉记者，如今，自动化所正在组织成立相关投资类公司，也在帮助创业的科学家去找基金、拉投资。“后续还将慢慢衍生出一个财务顾问机构，直接帮助所创企业对接财务问题，甚至还能帮助我们去寻找有限合伙人。”\n\n“这样特别有利于解放科学家去做专业的事情，因为有时候我们跟投资人谈问题，完全不在一个频道上。”王金桥说，类似于自动化所这样已拥有几十家创业企业的科研机构，完全有必要成立相应的专业机构，设法帮助科研人员更快地与市场接轨。\n\n来源：科学网', '2019-01-25 03:05:38', '新闻中心');
INSERT INTO `announcement` VALUES (4, '关于征集2019农业领域重大科学问题和工程技术 难题的通知', '学会各理事、分支机构，各农业科技工作者：\n为研判未来农业科技发展趋势、抓住农业科技创新突破口、前瞻谋划和布局前沿科技领域与方向提供依据，推进农业科技强国建设，根据《中国科协办公厅关于征集2019重大科学问题和工程技术难题的通知》有关要求，学会现面向各理事、各分支机构以及全国农业科技工作者征集“2019农业领域重大前沿科学问题与工程技术难题”。现就有关事项通知如下。\n\n一、征集时间\n\n即日起至2019年2月20日止。\n\n二、征集内容\n\n征集范围覆盖农业相关领域（包括交叉学科领域），对面向2050年的农业农村科技发展具有引领作用的前沿科学问题、工程技术难题。\n\n征集内容包括：问题题目、所属学科、关键词、问题描述，以及问题产生的背景、最新进展和重要意义等。正文长度为2000个汉字左右。除标题及关键词以中英文双语对照撰写外，其余内容均以中文撰写（附件1）。不按照规定格式撰写的问题、难题将不能进入遴选环节。\n\n三、其他事项\n\n1.学会将组织有关专家对征集的问题及难题进行遴选，并汇集成册呈送有关部门参考。\n\n2.学会将从征集的问题及难题中各遴选3-5项推荐到中国科协，中国科协将对推荐问题进行评议，从中遴选出对科学发展具有导向作用和对技术及产业创新具有关键作用的问题难题向社会发布。\n\n3.请于2019年2月20日前，将撰写的重大科学问题和工程技术难题发送至学会电子邮箱。\n\n望各理事、各分支机构以及各位农业科技工作者踊跃参与，汇聚智慧，共同为建设世界科技强国作出应有贡献。\n\n \n\n联 系 人：杜勇\n\n联系电话：010-59194497\n\n电子邮箱：nongxuehui2014@163.com\n\n', '2019-01-25 03:06:20', '新闻中心');
INSERT INTO `announcement` VALUES (5, '关于2018-2019年度神农中华农业科技奖推荐工作的通知', '各有关单位：\n\n　　神农中华农业科技奖是经原农业部、科技部批准设立的面向全国农业行业唯一综合性农业科技奖，是原农业部科技进步奖的继承和延伸，是农业农村部常设表彰项目。为进一步激励和调动广大农业科技人员的积极性，提高农业科技自主创新和协同创新能力，助力乡村振兴战略实施，根据《神农中华农业科技奖奖励办法》规定，决定启动2018-2019年度神农中华农业科技奖推荐和评审工作。现将有关事宜通知如下：\n\n　　一、成果内容要求\n\n　　推荐的成果应对我国农业绿色发展、高质量发展和乡村全面振兴等发挥重要作用，经济社会生态效益显著，同时符合《神农中华农业科技奖奖励办法》的规定和本通知要求：\n\n　　（一）科学研究类成果，应为绿色增产、资源节约、生态环保、质量安全等领域的新品种、关键技术和现代装备，具有创新性、先进性，对制约产业发展重大关键科技问题有突破；要求整体技术推广应用至少满2年，即成果完成时间截止2016年12月31日之前。\n\n　　（二）优秀创新团队，应为科研道德素质过硬、创新能力强、业绩贡献重大、团队效应突出、引领作用显著，在推进现代农业产业技术体系发展与创新中杰出的科学研究群体；要求在近5年内取得过重大科研成就，成果转化与产业化效益显著。\n\n　　（三）科普类成果，应为正式出版发行、面向农村农民的农业科普图书或电子出版物等；要求作品出版发行至少满2年，即2016年12月31日前出版发行的作品。\n\n　　（四）所有成果不得含有获得过国家科技奖或神农中华农业科技奖的技术内容。\n\n　　（五）所有成果完成单位必须是独立法人单位，每项成果只能通过一个推荐单位推荐。\n\n　　二、成果遴选与推荐\n\n　　（一）成果推荐单位\n\n　　中华农业科技奖实行归口和限额推荐，不接受非推荐单位和个人的推荐。\n\n　　1.各省、自治区、直辖市农业（农业农村、农牧、畜牧、海洋渔业、水利、农机）厅（委、局）、新疆生产建设兵团农业局，负责本辖区、本行业成果的统一推荐工作，各省级农学会协助配合。\n\n　　2.农业农村部直属单位以及具有推荐资格的非农业系统有关科研、教学单位，可直接向中华农业科技奖奖励委员会办公室（以下简称奖励办）推荐成果。\n\n　　3.鼓励有推荐资格的全国学会、协会，及港、澳、台地区的相关组织，向奖励办推荐成果。\n\n　　（二）遴选与公示\n\n　　1.推荐成果的遴选。为确保将真正优秀的成果推荐上来，各推荐单位应当建立科学合理的遴选推荐机制，本着公开、公平、公正的原则，组建专家组进行择优遴选。\n\n　　2.推荐成果的公示。各推荐单位应通过网络或书面形式对拟推荐成果进行公示，同时应责成成果前3完成人在所在单位进行公示，公示时间均不少于5个工作日，成果经公示无异议或虽有异议但经核实处理再次公示无异议方可推荐。\n\n　　3.推荐函。各推荐单位以正式公函形式报送材料，内容应包括成果遴选、专家择优评审情况，推荐数量、公示情况等；推荐函须附成果汇总表（.xlsx格式，通过网络推荐的请从推荐工作平台导出，见附件1）。\n\n　　三、有关要求\n\n　　（一）科研类和科普类成果的推荐\n\n　　1.成果材料填报。推荐单位指导成果完成单位登录全国农业科技成果转化交易服务平台（http://www.nzhw.org），点击报奖悬浮框或右上角“成果奖励”栏目进入中华农业科技奖网络申报与评审工作平台，按照《平台操作指南》（申报用户）填写推荐书中相关内容（推荐单位分配的用户名和密码），有关证明材料以原件扫描形成jpg格式文件上传至推荐平台，单个文件的大小不超过3M，文件总数不得超过54个。材料填写完成后提交给推荐单位。\n\n　　2.成果推荐。推荐单位登录“中华农业科技奖网络申报与评审工作平台”（请登录全国农业科技成果转化交易服务平台http://www.nzhw.org，点击报奖悬浮框凭用户名和密码进入），按照《平台操作指南》（推荐用户）在线审核成果材料、签署推荐意见，并点击提交推荐给奖励办。\n\n　　3.材料要求。推荐单位完成推荐提交后，成果完成单位方可通过申报平台，打印带有水印的《2018-2019年度神农中华农业科技奖推荐书》和《成果摘要表》纸质版（无水印者均视为无效资料），由推荐单位主要负责人签字并加盖单位公章。\n\n　　纸质版推荐书及其附件材料装订成册（必须含目次页并编页码），一式2份（推荐书附件材料签章的原件至少1份，否则视为不合格）；成果摘要表一式30份（不装订，以燕尾夹夹住）。同时报送所有申报材料的电子版（光盘），其中推荐函、《推荐书》和《成果摘要表》以pdf格式，附件材料以jpg格式（必须与上传附件一致）。\n\n　　（二）优秀创新团队类成果的推荐\n\n　　请登录全国农业科技成果转化交易服务平台（http://www.nzhw.org）主页，点击悬浮框或右上角“成果奖励”栏目，下载相应的推荐书。按照推荐书的格式和要求填写、打印、盖章。\n\n　　推荐书及其附件材料装订成册（必须含目次页并编页码），一式2份（推荐书附件材料签章的原件至少1份，否则视为不合格）；成果摘要表一式30份（不装订，以燕尾夹夹住）。同时报送所有材料的电子版（光盘），其中推荐书以word格式，附件材料以jpg格式（必须与纸质版附件一致）。\n\n　　（三）其他\n\n　　1.推荐工作手册下载。请成果完成单位和推荐单位相关人员登录全国农业科技成果转化交易服务平台（http://www.nzhw.org）主页,点击悬浮框或右上角“成果奖励”栏目，下载《2018-2019年度神农中华农业科技奖申报与推荐工作手册》，内含推荐书及其填写要求。请严格按照要求填写推荐书，确保材料的真实性、准确性、完整性、一致性。\n\n　　2.推荐指标及其用户名和密码。各推荐单位的推荐指标、登录“中华农业科技奖网络申报与评审工作平台”的用户名和密码，由奖励办另行通知下达。网络申报过程中如遇技术问题，请联系：400-808-6870，短信号码：15810006870。\n\n　　3.推荐起止时间。“中华农业科技奖网络申报与评审工作平台”将于2019年3月12日9时开通，4月12日17时关闭。\n\n　　4.推荐材料报送。纸质材料和电子版材料信息必须一致。申报材料要求不涉密，如果涉密请根据《中华人民共和国保守国家秘密法》和《科学技术保密规定》有关规定审核把关，妥善做好保密技术处理，并附说明（加盖成果完成单位公章）。\n\n　　推荐函（附项目汇总表）、《推荐书》及其附件材料、《成果摘要表》的纸质版材料和光盘，请于2019年4月15-19日报送至奖励办，逾期不予受理。\n\n　　地址：北京市朝阳区麦子店街22号710室\n\n　　中国农学会人才评价处，100125\n\n　　电话：010-59194211，59194210\n\n　　传真：010-59194211\n\n　　邮箱：rcpjc@163.com', '2019-01-25 03:06:50', '新闻中心');
INSERT INTO `announcement` VALUES (23, '新时代选人用人的基本规范', '啊啊啊啊啊啊啊啊或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或', '2019-03-19 01:06:15', '新闻中心');
INSERT INTO `announcement` VALUES (24, '臭居居大坏蛋', 'LastPass的密码管理器，一个屡获殊荣，保存你的密码给你访问的每台电脑和移动设备。只记得一个密码你的LastPass的主密码。保存你所有的用户名和密', '2019-03-19 14:03:11', '新闻中心');
INSERT INTO `announcement` VALUES (26, 'demo', 'demo demo', '2019-03-25 02:04:53', '新闻中心');
INSERT INTO `announcement` VALUES (27, '臭居居，你又能看见我了', '臭居居臭居居臭居居&nbsp;臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居臭居居&nbsp;', '2019-04-02 00:23:52', '新闻中心');
INSERT INTO `announcement` VALUES (28, '2', '2', '2019-04-05 02:01:05', '2');

-- ----------------------------
-- Table structure for demand
-- ----------------------------
DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand`  (
  `demand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求id',
  `demand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求名字',
  `expected_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '预期价格',
  `demanders` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求者（个人或机构）',
  `demand_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求说明',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `linkman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `page_view` int(11) NULL DEFAULT NULL COMMENT '点击量',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `organization_type_id` int(11) NULL DEFAULT NULL COMMENT '机构id',
  `status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态码（0未审核，1通过，2失败）',
  PRIMARY KEY (`demand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of demand
-- ----------------------------
INSERT INTO `demand` VALUES (3, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:27', '武凯焱', '15993023617', '911090257@qq.com', 0, 1, 1, '0');
INSERT INTO `demand` VALUES (4, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:27', '武凯焱', '15993023617', '911090257@qq.com', 0, 1, 1, '0');
INSERT INTO `demand` VALUES (5, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:27', '武凯焱', '15993023617', '911090257@qq.com', 0, 1, 1, '0');
INSERT INTO `demand` VALUES (6, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:27', '武凯焱', '15993023617', '911090257@qq.com', 0, 1, 1, '0');
INSERT INTO `demand` VALUES (7, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:27', '武凯焱', '15993023617', '911090257@qq.com', 0, 1, 1, '0');
INSERT INTO `demand` VALUES (9, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:25', '武凯焱er', '15993023617', '911090257@qq.com\n\n', 0, 1, 9, '1');
INSERT INTO `demand` VALUES (10, '生物质成型燃料高效燃烧技术和装置', 23.00, '胡亚星', '企 业 现 占 地 80 亩 左 右 ，建 筑 面 积 约 4 万 ? 设 备 大 型 半 自 动 喷 涂 流 水 线 和 部 分 的 数 控 加 工 设 备、 产 品 有 塑 料、 玻 璃、不 锈 钢 真 空 杯。', '2019-01-21 01:15:25', '武凯焱er', '15993023617', '911090257@qq.com\n\n', 0, 1, 9, '1');
INSERT INTO `demand` VALUES (12, NULL, NULL, NULL, NULL, '2019-02-21 02:07:16', NULL, NULL, NULL, 0, NULL, NULL, '0');
INSERT INTO `demand` VALUES (13, NULL, NULL, NULL, NULL, '2019-02-21 02:07:31', NULL, NULL, NULL, 0, NULL, NULL, '0');
INSERT INTO `demand` VALUES (44, '大使', 1500.00, '王静晓', 'pk', '2019-04-03 03:52:39', '胡亚星', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (46, '农业转化', 121.00, '王静晓', '暂无', '2019-04-03 13:32:44', '王冰', '13598212954', '2498584007@qq.com', 12, 1, 1, '2');
INSERT INTO `demand` VALUES (47, '嗯啊', 1500.00, '的速度', '阿萨德', '2019-04-04 00:25:42', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (48, '农业转化', 121.00, '王静晓', '暂无啊', '2019-04-04 06:17:48', '王冰', '15936571965', '2498584007@qq.com', 12, 1, 1, '1');
INSERT INTO `demand` VALUES (49, '谢兴博', 121.00, '鞠婧祎', '暂无', '2019-04-04 06:19:40', '蒋靓峣', '15936571965', '2498584007@qq.com', 1111, 1, 1, '2');
INSERT INTO `demand` VALUES (50, '王静晓', 1500.00, '的速度', '阿萨德', '2019-04-04 12:55:46', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (51, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:56:01', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (52, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:57:56', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (53, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:58:07', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (54, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:58:17', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (55, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:58:30', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');
INSERT INTO `demand` VALUES (56, '我就差', 1500.00, '的速度', '阿萨德', '2019-04-04 12:58:40', '发斯蒂芬', '15936518126', '2962784374@qq.com', 0, 3, NULL, '0');

-- ----------------------------
-- Table structure for demand_type
-- ----------------------------
DROP TABLE IF EXISTS `demand_type`;
CREATE TABLE `demand_type`  (
  `demand_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `demand_id` int(11) NULL DEFAULT NULL COMMENT '需求编号id',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`demand_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example`  (
  `example_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '案例id',
  `example_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '案例标题',
  `example_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '案例内容',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态码（0未审核，1通过，2失败）',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`example_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of example
-- ----------------------------
INSERT INTO `example` VALUES (1, '“羊肉加工增值关键技术”顺利转化，经济社会效益显著', '123456中国农科院加工所“羊肉加工增值关键技术”通过冷鲜羊肉加工新技术的应用，大幅度降低了冷鲜羊肉加工与贮运过程中的损耗，提高了品质，延长了货架期，该成果在内蒙古蒙都羊业食品有限公司进行了转化，建立了冷鲜分割羊肉、风干羊肉和羊骨素加工多条生产线，产生显著的经济与社会效益。', '2019-01-26 00:31:33', '2', 2);
INSERT INTO `example` VALUES (2, NULL, NULL, '2019-03-19 07:24:02', '0', NULL);
INSERT INTO `example` VALUES (3, NULL, NULL, '2019-03-19 07:24:05', '0', NULL);
INSERT INTO `example` VALUES (4, NULL, NULL, '2019-03-19 07:24:07', '0', NULL);
INSERT INTO `example` VALUES (5, NULL, NULL, '2019-03-19 07:24:45', '0', NULL);
INSERT INTO `example` VALUES (6, NULL, NULL, '2019-03-19 07:28:18', '0', NULL);
INSERT INTO `example` VALUES (7, 'fgfddf', '我以后尽量少说话&nbsp;&nbsp;', '2019-03-19 07:55:33', '0', 11);
INSERT INTO `example` VALUES (8, '臭居居', '得不到的永远在骚动，被偏爱的都有恃无恐', '2019-03-19 13:23:49', '0', 1);
INSERT INTO `example` VALUES (10, '1', '1111111过分个', '2019-03-20 00:42:06', '0', 12);
INSERT INTO `example` VALUES (12, '少说话多做事情', '得不到的永远在骚动，被偏爱的都有恃无恐 得不到的永远在骚动，被偏爱的都有恃无恐得不到的永远在骚动，被偏爱的都有恃无恐&nbsp;', '2019-03-20 00:54:10', '0', 1);
INSERT INTO `example` VALUES (13, '完完全全发', '的问问热风怪不得法规', '2019-03-20 11:58:37', '0', 12);
INSERT INTO `example` VALUES (14, '暂无', NULL, '2019-03-25 01:59:41', '1', 1);
INSERT INTO `example` VALUES (19, '多福多寿', '臭居居借鉴借鉴军军军军军', '2019-04-03 12:16:30', '0', 1);
INSERT INTO `example` VALUES (20, '刚发的', '请编写该案例的内容详情规划局发给就', '2019-04-03 13:02:33', '2', 1);
INSERT INTO `example` VALUES (26, '嘿嘿哇', '大萨达所', '2019-04-03 14:32:27', '1', 3);
INSERT INTO `example` VALUES (27, '等等啊我的青春', '说起青涩简单的校园生活，大家一定不会忘记那个在校服上害羞地签上自己名字的女孩、那个骑着单车从自己身边飞驰而过的男孩、还有那段同室友在宿舍飙歌的时光。青春或美好或哀伤的回忆总是能让人笑着笑着眼泪又湿了眼眶。&nbsp;&nbsp;', '2019-04-04 06:12:38', '1', 11);
INSERT INTO `example` VALUES (28, '电饭锅', '发给', '2019-04-04 06:21:28', '2', 3);
INSERT INTO `example` VALUES (29, ' dk', 'gjvopdfbj;s cnvm,bnsdl', '2019-04-04 13:01:02', '1', 1);
INSERT INTO `example` VALUES (30, '第三方的水电费', '士大夫撒地方胜多负少', '2019-04-05 00:48:33', '0', 3);

-- ----------------------------
-- Table structure for experts
-- ----------------------------
DROP TABLE IF EXISTS `experts`;
CREATE TABLE `experts`  (
  `experts_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专家id',
  `experts_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `experts_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `experts_birth` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `experts_country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `experts_education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所学专业',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在单位',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政职务',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '专家类型id',
  `picture_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `research_field` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '研究领域',
  `research_achievements` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '主要研究成果简介',
  `personal_prize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人获奖状况',
  `results_prize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果获奖状况',
  `experts_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `experts_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态码（0未审核，1通过，2失败）',
  `page_view` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '点击量',
  PRIMARY KEY (`experts_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of experts
-- ----------------------------
INSERT INTO `experts` VALUES (1, '康绍忠', '男', '1962-10-31 16:00:00', '中国', '研究生', '名誉博士', '西北农业大学', '农业水土工程', '中国农业大学中国农业水问题研究中心', '中国工程院院士', 1, '/HeadPortrait/2744320190222.jpg', '农业水土工程、旱区农业节水与水资源持续高效利用的研究，土壤植物大气系（SPAC）, 水分运转与节水调控理论的研究，作物需水估算模型的研究，生态需水计算方法、农业与生态用水配置理论的研究', '先后主持和参加科研课题25项，其中主持的有19项，包括国家杰出青年基金1项，国家“九五”攻关项目1项、国家自然科学基金4项、霍英东高校青年教师奖励基金1项、中科院“百人计划”项目1项等重大项目，主持完成的“农田水分微循环规律及其节水调控原理”研究成果经评审居国际先进水平，获1996年水利部科技进步一等奖。主持完成的国家自然科学基金项目“土壤-植物-大气连续体水分运移理论及其应用的研究”开拓了新的领域，经鉴定认为该成果居国际先进水平，获1993年陕西省人民政府科技进步二等奖，并被国家基金委选为优秀成果。主持完成的“陕西省作物需水量及分区灌溉模式的研究”成果提出了作物高产的最小需水量，不同供水条件下的土壤适宜水分条件,灌溉分区及不同区域的节水高产型灌溉制度和有限水量条件下的节水优产型灌溉制度，经鉴定居国内领先水平，获1992年陕西省水利科技进步二等奖。主持完成的“汉中地区水稻需水量与合理灌溉研究”成果获1989年汉中地区行署科技进步三等奖。作为主要技术骨干完成的“SPAC水分运移力能关系的理论分析”成果获1990年陕西省人民政府科技进步二等奖。参加完成的“中国主要农作物需水量等值线图研究”成果获1993年水利部科技进步三等奖。主著和合著科技专著6部，其中主著的《sPAC水分传输理论及其应用》、《西北地区农业节水与水资源持续利用》分别获水利部首届科技专著出版基金和首届中华农业科教专著出版基金的资助，被作为重点图书出版，《中国主要农作物需水量与灌溉》专著获水利部优秀水利科技著作一等奖。在国内外公开发表学术论文80余篇，有10余篇论文曾分别获陕西省自然科学优秀学术论文奖等奖励。他的研究居国际先进水平，已形成了具有鲜明特色的研究体系，在国内外具有广泛的影响。首次系统的探索了SPAC水分传输的力能关系，修正并完善了国际上采用较多的Van den Honert关于SPAC水流通量与水势差关系的假设。建立的作物根系吸水模式经许多专家应用明显优于目前国际上通用的Novak等模型，提出的作物叶面蒸腾与棵间蒸发分摊系数计算模式明显优于Richie和Burnet及childs等建立的模式。首次提出了“控制性分根交替灌溉”新方法，经实际应用节水36．4％，为我国北方旱区农业节水开辟了新的途径；提出的陕西省主要农作物需水量等值线图和分区灌溉模式，己在全省水地节水增产潜力调查与分析、节水区划、灌溉用水管理、灌区水资源评价等实际工作中广泛应用，多年来取得了巨大的经济与社会效益。', '21', NULL, '15936571965', NULL, 1, '0', '0');
INSERT INTO `experts` VALUES (2, '康绍忠', '男', '1962-10-31 16:00:00', '中国', '研究生', '名誉博士', '西北农业大学', '农业水土工程', '中国农业大学中国农业水问题研究中心', '中国工程院院士', 1, '/HeadPortrait/2744320190222.jpg', '农业水土工程、旱区农业节水与水资源持续高效利用的研究，土壤植物大气系（SPAC）, 水分运转与节水调控理论的研究，作物需水估算模型的研究，生态需水计算方法、农业与生态用水配置理论的研究', '先后主持和参加科研课题25项，其中主持的有19项，包括国家杰出青年基金1项，国家“九五”攻关项目1项、国家自然科学基金4项、霍英东高校青年教师奖励基金1项、中科院“百人计划”项目1项等重大项目，主持完成的“农田水分微循环规律及其节水调控原理”研究成果经评审居国际先进水平，获1996年水利部科技进步一等奖。主持完成的国家自然科学基金项目“土壤-植物-大气连续体水分运移理论及其应用的研究”开拓了新的领域，经鉴定认为该成果居国际先进水平，获1993年陕西省人民政府科技进步二等奖，并被国家基金委选为优秀成果。主持完成的“陕西省作物需水量及分区灌溉模式的研究”成果提出了作物高产的最小需水量，不同供水条件下的土壤适宜水分条件,灌溉分区及不同区域的节水高产型灌溉制度和有限水量条件下的节水优产型灌溉制度，经鉴定居国内领先水平，获1992年陕西省水利科技进步二等奖。主持完成的“汉中地区水稻需水量与合理灌溉研究”成果获1989年汉中地区行署科技进步三等奖。作为主要技术骨干完成的“SPAC水分运移力能关系的理论分析”成果获1990年陕西省人民政府科技进步二等奖。参加完成的“中国主要农作物需水量等值线图研究”成果获1993年水利部科技进步三等奖。主著和合著科技专著6部，其中主著的《sPAC水分传输理论及其应用》、《西北地区农业节水与水资源持续利用》分别获水利部首届科技专著出版基金和首届中华农业科教专著出版基金的资助，被作为重点图书出版，《中国主要农作物需水量与灌溉》专著获水利部优秀水利科技著作一等奖。在国内外公开发表学术论文80余篇，有10余篇论文曾分别获陕西省自然科学优秀学术论文奖等奖励。他的研究居国际先进水平，已形成了具有鲜明特色的研究体系，在国内外具有广泛的影响。首次系统的探索了SPAC水分传输的力能关系，修正并完善了国际上采用较多的Van den Honert关于SPAC水流通量与水势差关系的假设。建立的作物根系吸水模式经许多专家应用明显优于目前国际上通用的Novak等模型，提出的作物叶面蒸腾与棵间蒸发分摊系数计算模式明显优于Richie和Burnet及childs等建立的模式。首次提出了“控制性分根交替灌溉”新方法，经实际应用节水36．4％，为我国北方旱区农业节水开辟了新的途径；提出的陕西省主要农作物需水量等值线图和分区灌溉模式，己在全省水地节水增产潜力调查与分析、节水区划、灌溉用水管理、灌区水资源评价等实际工作中广泛应用，多年来取得了巨大的经济与社会效益。', '21', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');
INSERT INTO `experts` VALUES (3, '康绍忠', '男', '1962-10-31 16:00:00', '中国', '研究生', '名誉博士', '西北农业大学', '农业水土工程', '中国农业大学中国农业水问题研究中心', '中国工程院院士', 1, '/HeadPortrait/2744320190222.jpg', '农业水土工程、旱区农业节水与水资源持续高效利用的研究，土壤植物大气系（SPAC）, 水分运转与节水调控理论的研究，作物需水估算模型的研究，生态需水计算方法、农业与生态用水配置理论的研究', '先后主持和参加科研课题25项，其中主持的有19项，包括国家杰出青年基金1项，国家“九五”攻关项目1项、国家自然科学基金4项、霍英东高校青年教师奖励基金1项、中科院“百人计划”项目1项等重大项目，主持完成的“农田水分微循环规律及其节水调控原理”研究成果经评审居国际先进水平，获1996年水利部科技进步一等奖。主持完成的国家自然科学基金项目“土壤-植物-大气连续体水分运移理论及其应用的研究”开拓了新的领域，经鉴定认为该成果居国际先进水平，获1993年陕西省人民政府科技进步二等奖，并被国家基金委选为优秀成果。主持完成的“陕西省作物需水量及分区灌溉模式的研究”成果提出了作物高产的最小需水量，不同供水条件下的土壤适宜水分条件,灌溉分区及不同区域的节水高产型灌溉制度和有限水量条件下的节水优产型灌溉制度，经鉴定居国内领先水平，获1992年陕西省水利科技进步二等奖。主持完成的“汉中地区水稻需水量与合理灌溉研究”成果获1989年汉中地区行署科技进步三等奖。作为主要技术骨干完成的“SPAC水分运移力能关系的理论分析”成果获1990年陕西省人民政府科技进步二等奖。参加完成的“中国主要农作物需水量等值线图研究”成果获1993年水利部科技进步三等奖。主著和合著科技专著6部，其中主著的《sPAC水分传输理论及其应用》、《西北地区农业节水与水资源持续利用》分别获水利部首届科技专著出版基金和首届中华农业科教专著出版基金的资助，被作为重点图书出版，《中国主要农作物需水量与灌溉》专著获水利部优秀水利科技著作一等奖。在国内外公开发表学术论文80余篇，有10余篇论文曾分别获陕西省自然科学优秀学术论文奖等奖励。他的研究居国际先进水平，已形成了具有鲜明特色的研究体系，在国内外具有广泛的影响。首次系统的探索了SPAC水分传输的力能关系，修正并完善了国际上采用较多的Van den Honert关于SPAC水流通量与水势差关系的假设。建立的作物根系吸水模式经许多专家应用明显优于目前国际上通用的Novak等模型，提出的作物叶面蒸腾与棵间蒸发分摊系数计算模式明显优于Richie和Burnet及childs等建立的模式。首次提出了“控制性分根交替灌溉”新方法，经实际应用节水36．4％，为我国北方旱区农业节水开辟了新的途径；提出的陕西省主要农作物需水量等值线图和分区灌溉模式，己在全省水地节水增产潜力调查与分析、节水区划、灌溉用水管理、灌区水资源评价等实际工作中广泛应用，多年来取得了巨大的经济与社会效益。', '21', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');
INSERT INTO `experts` VALUES (12, '胡亚星', '男', '2019-04-01 16:00:00', '中国', '其他', '其他', '河南科技学院', '虚心', '现在', '程序', 1, '/HeadPortrait/8260420190402.jpg', '是否', 'vf', '21', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');
INSERT INTO `experts` VALUES (13, '臭居居', '女', '2019-04-01 16:00:00', '中国', '博士研究生', '名誉博士', '河南科技学院', '虚心', '现在', '程序', 1, '/HeadPortrait/7163620190402.jpg', '鼎折覆餗', '地方深V', '21', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');
INSERT INTO `experts` VALUES (14, '蒋靓峣', '女', '2019-02-05 16:00:00', '中国', '研究生', '名誉博士', '河南科技学院', '虚心', '现在', '程序', 1, '/HeadPortrait/5137520190402.jpg', '的算法深V', '21', '但是', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');
INSERT INTO `experts` VALUES (15, '侯昆昊', '男', '2011-04-05 16:00:00', '中国', '研究生', '名誉博士', '河南科技学院', '大数据', '未来工作室', '暂无', 1, '/HeadPortrait/4241020190402.jpg', 'xxxxx', 'hhhxx', '21', '21', '1593657195', '1787583716@qq.com', 1, '0', '0');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `organization_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `organization_country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在国家',
  `organization_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `legal_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人类别',
  `organization_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构简介',
  `linkman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `organization_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网址',
  `contact_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `organization_type_id` int(11) NULL DEFAULT NULL COMMENT '机构类型id',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构类型',
  `status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态码（0未审核，1通过，2失败）',
  `organization_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构logo',
  PRIMARY KEY (`organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (2, '的规范地方', '电饭锅', '电饭锅', '单个', '电饭锅', '发斯蒂芬', '15936518126', '2962784374@qq.com', 'http://www.nzhw.org/chengguo/unitservice/getqiantaiUnitsDetailsAction?units.id=7821', '1500', 3, 2, '评估机构', NULL, NULL);
INSERT INTO `organization` VALUES (3, '的规范地方', '电饭锅', '电饭锅', '单个', '电饭锅', '发斯蒂芬', '15936518126', '2962784374@qq.com', 'http://www.nzhw.org/chengguo/unitservice/getqiantaiUnitsDetailsAction?units.id=7821', '1500', 3, 3, '龙头企业', NULL, NULL);
INSERT INTO `organization` VALUES (4, '1213', '12313', '1213', '12', '21', '12', '15936518126', '2962784374@qq.com', 'http://www.nzhw.org/chengguo/unitservice/getqiantaiUnitsDetailsAction?units.id=7821', '1500', 3, 4, '产权交易中心', NULL, NULL);

-- ----------------------------
-- Table structure for organization_type
-- ----------------------------
DROP TABLE IF EXISTS `organization_type`;
CREATE TABLE `organization_type`  (
  `organization_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构类型id',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`organization_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization_type
-- ----------------------------
INSERT INTO `organization_type` VALUES (1, '科研教学');
INSERT INTO `organization_type` VALUES (2, '评估机构');
INSERT INTO `organization_type` VALUES (3, '龙头企业');
INSERT INTO `organization_type` VALUES (4, '产权交易中心');
INSERT INTO `organization_type` VALUES (5, '知识产权代理');
INSERT INTO `organization_type` VALUES (6, '融资租赁');
INSERT INTO `organization_type` VALUES (11, '管理机构');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '种业');
INSERT INTO `type` VALUES (2, '种植');
INSERT INTO `type` VALUES (3, '养殖');
INSERT INTO `type` VALUES (4, '农产品与食品加工');
INSERT INTO `type` VALUES (5, '植物保护');
INSERT INTO `type` VALUES (6, '动物疫病防控');
INSERT INTO `type` VALUES (7, '资源与环境');
INSERT INTO `type` VALUES (8, '农机装备与农业设施');
INSERT INTO `type` VALUES (9, '农业、农村信息化');
INSERT INTO `type` VALUES (10, '生物质能源与生物基材料');
INSERT INTO `type` VALUES (11, '林木资源培育与林产加工');
INSERT INTO `type` VALUES (12, '农业生态与农村环保');
INSERT INTO `type` VALUES (13, '农业防灾减灾');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `user_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户等级（1是管理员，2是专家，3是普通用户）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'huyaxing', '911090257@qq.com', '15993023617', '19980517zlp', '湖北省-潜江市-潜江市', '1');
INSERT INTO `user` VALUES (2, '123', 'zxc', '123412', '123', '湖北省-天门市-天门市', '3');
INSERT INTO `user` VALUES (3, '1234', '1787583716@qq.com', '15936571964', '12345', '河南省-驻马店市-遂平县', '2');
INSERT INTO `user` VALUES (9, '1', '1', '1', '1', '湖南省-怀化市-靖州苗族侗族自治县', '1');
INSERT INTO `user` VALUES (11, 'BY233', '1787583316@qq.com', '15936571963', '171219', '广东省-潮州市-湘桥区', '2');
INSERT INTO `user` VALUES (14, 'BY2456', '1787583786@qq.com', '15936571962', '171219', '江西省-景德镇市-昌江区', '1');
INSERT INTO `user` VALUES (20, '臭居居cjj', '1787583718@qq.com', '13598212951', '1219', '福建省-福州市-平潭县', '1');
INSERT INTO `user` VALUES (21, '臭居居jhuj', '178758371@qq.com', '13598212954', '12191', '湖北省-潜江市-潜江市', '1');
INSERT INTO `user` VALUES (22, 'BY', '1787583711@qq.com', '18238136535', '1219', '湖南省-邵阳市-大祥区', '1');
INSERT INTO `user` VALUES (23, '谢兴博', '1787583712@qq.com', '15936571961', 'xxb', '河南省-信阳市-淮滨县', '1');
INSERT INTO `user` VALUES (24, '王福坤', '1787583725@qq.com', '15936571969', 'wfkdhd', '河南省-新乡市-红旗区', '2');

SET FOREIGN_KEY_CHECKS = 1;
