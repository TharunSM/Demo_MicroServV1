use ValorantHub;
#schema being used if not exist create this schema using ur credentials

CREATE TABLE IF NOT EXISTS valorant_skin_hub  (
    vskin_id INT AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(255) ,
    bundle_name VARCHAR(255),
    icon_vert VARCHAR(255),
    icon_hori VARCHAR(255),
    rating INT,
    bundle_avail VARCHAR(255),
    price INT,
    currency_type VARCHAR(255)
);

select count(*) from valorant_skin_hub;
select * from valorant_skin_hub where bundle_name Like 'Doombringer';

drop table valorant_skin_hub