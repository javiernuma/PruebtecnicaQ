import {Song} from "./song";

export  class Lista{
  id: number;
  nombreLista: string;
  descripcion: string;
  listaCanciones: Song[] = [];
}
