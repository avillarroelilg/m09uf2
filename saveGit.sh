#!/bin/bash

# empezamos !!!
echo "<< Hola!!,comencemos ^-^ >>"
echo "		escribe el commit >>:"
read commit
if [ -z "$commit" ];
	then
		echo "tiene que pasarme un el texto del commit :("

else
	#echo " >>se ejecuta el script: ,$commit"
	git add . && git commit -a -m "commit:$commit" && git push
	#git add . && git commit -m"commit:$commit"
	#cachear credenciales creo que son 3 horas
	#git config --global credential.helper 'cache --timeout=10800'
fi
