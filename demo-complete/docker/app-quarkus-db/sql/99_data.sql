-- CHEFLIEU - Chef-lieu d'arrondissement, de département, de région ou bureau centralisateur
insert into code(famille, code, libelle) values ('CHEFLIEU', '0', 'commune non chef-lieu');
insert into code(famille, code, libelle) values ('CHEFLIEU', '1', 'commune bureau centralisateur de canton');
insert into code(famille, code, libelle) values ('CHEFLIEU', '2', 'commune chef-lieu d''arrondissement');
insert into code(famille, code, libelle) values ('CHEFLIEU', '3', 'commune chef-lieu de département');
insert into code(famille, code, libelle) values ('CHEFLIEU', '4', 'commune chef-lieu de région');

-- CDC - Découpage de la commune en cantons
insert into code(famille, code, libelle) values ('CDC', '0', 'commune non découpée en cantons');
insert into code(famille, code, libelle) values ('CDC', '1', 'fraction cantonale');
insert into code(famille, code, libelle) values ('CDC', '2', 'canton non précisé');

-- TNCC - Type de nom en clair
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (0, true, 'pas d''article et le nom commence par une consonne sauf H muet. Charnière = DE', null, 'DE');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (1, true, 'pas d''article et le nom commence par une voyelle ou un H muet. Charnière = D''', null, 'D''');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (2, true, 'article = LE Charnière = DU', 'LE', 'DU');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (3, true, 'article = LA Charnière = DE LA', 'LA', 'DE LA');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (4, true, 'article = LES Charnière = DES', 'LES', 'DES');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (5, true, 'article = L'' Charnière = DE L''', 'L''', 'DE L''');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (6, true, 'article = AUX Charnière = DES', 'AUX', 'DES');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (7, true, 'article = LAS Charnière = DE LAS', 'LAS', 'DE LAS');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (8, true, 'article = LOS Charnière = DE LOS', 'LOS', 'DE LOS');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (0, false, 'pas d''article et le nom commence par une consonne sauf H muet. Charnière = de', null, 'de');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (1, false, 'pas d''article et le nom commence par une voyelle ou un H muet. Charnière = d''', null, 'd''');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (2, false, 'article = LE Charnière = DU', 'le', 'du');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (3, false, 'article = LA Charnière = DE LA', 'la', 'de la');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (4, false, 'article = LES Charnière = DES', 'les', 'des');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (5, false, 'article = L'' Charnière = DE L''', 'l''', 'de l''');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (6, false, 'article = AUX Charnière = DES', 'aux', 'des');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (7, false, 'article = LAS Charnière = DE LAS', 'las', 'de las');
insert into type_nom(type_nom, uppercase, commentaire, article, charniere) values (8, false, 'article = LOS Charnière = DE LOS', 'los', 'de losLOS');
