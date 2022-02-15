#!/bin/bash

# empezamos !!
echo "habilitamos cache para 3H."
git config --global credential.helper 'cache --timeout=10800'
echo "<< Hola!!,comencemos ^-^ >>"
echo "		escribe el commit >>:"
read commit
if [ -z "$commit" ];
	then
		echo "tiene que pasarme un el texto del commit :("

else
	#echo " >>se ejecuta el script: ,$commit"
	git add . && git commit -a -m "commit:$commit" && git push
	
fi
