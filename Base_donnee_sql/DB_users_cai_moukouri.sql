-- Structure de la table `Users`

CREATE TABLE `bd_cai_moukouri`.`DB_users_cai_moukouri` ( `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id du user' , `login` VARCHAR(255) NOT NULL COMMENT 'le login choisi par le user' , `password` VARCHAR(255) NOT NULL , `prenom` VARCHAR(255) NOT NULL , `nom` VARCHAR(255) NOT NULL , `pseudo` VARCHAR(255) NOT NULL , `mail` VARCHAR(255) NOT NULL , `sexe` VARCHAR(255) NOT NULL , `date_de_naissance` DATE NOT NULL , PRIMARY KEY (`id`), UNIQUE (`login`)) ENGINE = InnoDB COMMENT = 'la table des utilisateurs';

INSERT INTO `DB_users_cai_moukouri` (`id`, `login`, `password`, `prenom`, `nom`, `pseudo`, `mail`, `sexe`, `date_de_naissance`) VALUES ('1', 'login_A', 'password_A', 'prenom_A', 'nom_A', 'pseudo_A', 'mail_A@sorbonne.fr', 'F', '1998-04-12'), (NULL, 'login_B', 'password_B', 'prenom_B', 'nom_B', 'pseudo_B', 'mail_B@sorbonne.fr', 'M', '1999-03-10'), (NULL, 'login_C', 'password_C', 'prenom_C', 'nom_C', 'pseudo_C', 'mail_C@sorbonne.fr', 'F', '2000-03-10');






CREATE TABLE `bd_cai_moukouri`.`DB_friends_cai_moukouri` ( `id1` INT NOT NULL , `id2` INT NOT NULL COMMENT 'id1 est l\'ami de id2' , `date` DATE NOT NULL , `nb_ami_commun` INT NOT NULL ,FOREIGN Key (id1) REFERENCES `DB_users_cai_moukouri` (`id` ), FOREIGN Key (`id2`) REFERENCES `DB_users_cai_moukouri` (`id`), PRIMARY KEY (`id1`, `id2`)) ENGINE = InnoDB;

INSERT INTO `DB_friends_cai_moukouri` (`id1`, `id2`, `date`, `nb_ami_commun`) VALUES ('1', '2', CURRENT_DATE() , '0'), ('2', '1', CURRENT_DATE(), '0');



CREATE TABLE `bd_cai_moukouri`.`DB_authentification_cai_moukouri` ( `id` INT NOT NULL AUTO_INCREMENT , `token` VARCHAR(256) NOT NULL , `date_debut` TIME NOT NULL , `date_fin` TIME NOT NULL , FOREIGN Key (id) REFERENCES `DB_users_cai_moukouri` (`id` ), PRIMARY KEY (`id`), UNIQUE (`token`)) ENGINE = InnoDB;



