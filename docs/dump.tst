To get a copy of the uat database for safety:
Create it on server:
    cd scripts
    dump_grantsUAT.sh

Change dump.sql ownership to apg:apg

Then at home:

run  scp -P 9825 git.carricksoftware.co.uk:/home/apg/scripts/dump.sql  files/dump.sql