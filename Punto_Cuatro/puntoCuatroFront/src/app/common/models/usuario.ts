export  class Usuario{
    id: number;
    login: string;
    contrasena: string;
    habilitado: string;
    nombre: string;
    apellido: string;
    correo: string;
    roles: string[] = [];
    length: number;
}
