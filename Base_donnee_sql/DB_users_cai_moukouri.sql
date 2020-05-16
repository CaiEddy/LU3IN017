-- Structure de la table `Users`

CREATE TABLE `bd_cai_moukouri`.`DB_users_cai_moukouri` ( `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id du user' , `login` VARCHAR(255) NOT NULL COMMENT 'le login choisi par le user' , `password` VARCHAR(255) NOT NULL , `prenom` VARCHAR(255) NOT NULL , `nom` VARCHAR(255) NOT NULL , `pseudo` VARCHAR(255) NOT NULL , `mail` VARCHAR(255) NOT NULL , `sexe` VARCHAR(255) NOT NULL , `date_de_naissance` DATE NOT NULL , PRIMARY KEY (`id`), UNIQUE (`login`)) ENGINE = InnoDB COMMENT = 'la table des utilisateurs';

INSERT INTO `DB_users_cai_moukouri` (`id`, `login`, `password`, `prenom`, `nom`, `pseudo`, `mail`, `sexe`, `date_de_naissance`) VALUES ('1', 'Chako', 'luludu38', 'lucie', 'CUBAUD', 'Luludu95', 'luciepartoutmemedanston@upmc.ufr', 'F', '2002-02-11'), (NULL, 'Caiment', 'CaimentduBenin', 'Eddy', 'CAI', 'CaimentduMalawi', 'Cai.eddy@tjr_pas_validé_un_S1', 'H', '1995-02-28'),(NULL, 'emmnms', 'emmanuellita54648fe@//zuiydzual', 'emmanuelle', 'UPMC', 'la_pote_de_lulu_du38', 'emmanuelle@upmc.etu', 'F', '2002-02-11');






CREATE TABLE `bd_cai_moukouri`.`DB_friends_cai_moukouri` ( `id1` INT NOT NULL , `id2` INT NOT NULL COMMENT 'id1 est l\'ami de id2' , `date` DATE NOT NULL , `nb_ami_commun` INT NOT NULL ,FOREIGN Key (id1) REFERENCES `DB_users_cai_moukouri` (`id` ), FOREIGN Key (`id2`) REFERENCES `DB_users_cai_moukouri` (`id`), PRIMARY KEY (`id1`, `id2`)) ENGINE = InnoDB;

INSERT INTO `DB_friends_cai_moukouri` (`id1`, `id2`, `date`, `nb_ami_commun`) VALUES ('1', '2', CURRENT_DATE() , '0'), ('2', '1', CURRENT_DATE(), '0');



CREATE TABLE `bd_cai_moukouri`.`DB_authentification_cai_moukouri` ( `id` INT NOT NULL AUTO_INCREMENT , `token` VARCHAR(256) NOT NULL , `date_debut` TIME NOT NULL , `date_fin` TIME NOT NULL , FOREIGN Key (id) REFERENCES `DB_users_cai_moukouri` (`id` ), PRIMARY KEY (`id`), UNIQUE (`token`)) ENGINE = InnoDB;



