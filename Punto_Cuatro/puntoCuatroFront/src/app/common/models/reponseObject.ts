import {ObjectContentResponse} from './objectContentResponse';

export interface ReponseObject<T>{
  code: string;
  message: string;
  body: ObjectContentResponse<T>;
}
