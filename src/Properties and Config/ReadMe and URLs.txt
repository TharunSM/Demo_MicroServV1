
General Info:

http://localhost:8091/v1/healthcheck - to test if the server is up.

Logging info general format - logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.callExternalApi() -- Service == VALORANTAPI CALL WORKING---------");

Making a Valorant Skins db with user rating, price and availability criteria (store(green) ,nightmarket(purple), event(gold))

Home API : https://dash.valorant-api.com/

setup up your db password in environment variable as VALO_HUB_DB_PASSWORD

using this api to get valorant skin bundle info
https://valorant-api.com/v1/bundles


If we want to update the rating in the db for a bundle:
(current rating from db + our presently added rating sent by the user) / the total rating count
convert it to round() and add it back to the db for that uid

rateing count -- number of users rated this bundle
--------------------------------------------------

Features:

Must make another table and POJO for AllInfoBundle - done

rating table and main table must contain timestamp - rating table added, timestamp no need for now

Main Table must contain bundle details - must add

add slf4j or aop - doing

must add POST methods for adding rateing for that given bundle


----------------------------------------------------

Add on:

by default runs in port 8091

Buy or use a cheap vps to host the application in cloud for domain use netlify

make some endpoints admin only like update, insert


we can nginx for run of http server

we can use certbot if we want free ssl if we buy a domain

add credits to the api



f1 api:
https://ergast.com/mrd/methods/seasons/
https://github.com/jolpica/jolpica-f1