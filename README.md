# JARVIS_PORT_CHECKER
Herramienta para comprobar puertos abiertos en multitud de dispositivos.
El funcionamiento es simple, se le brinda un input de hot, y puerto remoto a comprobar, el algoritmo crea n cantidad de host virtuales, 
cada uno ejecuta su prueba de port open individualmente, escribiendo en archivos separados, los logs de los host ok, alcanzables, y los host no alcanzables.
Cabe destacar que no tiene límite de host a crear, se ha probado con 23000 dispositivos, y funciona a la perfección, controla el uso de memoria ram, ya que 
no permite la creación de mas de 1000 host virtuales a la vez, y a medida que cada host virtual va escribiendo en los archivos de logs, estos finalizan su ciclo de vida
dando lugar a la creación de nuevos host virtuales.

# JARVIS_PORT_CHECKER
Tool to check open ports on a multitude of devices.
The operation is simple, it is given a hot input, and remote port to check, the algorithm creates n number of virtual hosts,
each runs its port open test individually, writing to separate files the logs of hosts ok, reachable, and hosts not reachable.
It should be noted that it has no host limit to create, it has been tested with 23000 devices, and it works perfectly, it controls the use of ram memory, since
it does not allow the creation of more than 1000 virtual hosts at the same time, and as each virtual host writes to the log files, they end their life cycle
leading to the creation of new virtual hosts.

