import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest, HttpParams } from '@angular/common/http';
import { BaseOperation } from './baseOperation';
import { environment } from '../../environment';

export abstract class BaseService<T, ID> implements BaseOperation<T, ID> {

     httpOptions = {
        headers: new HttpHeaders({ 
            'Access-Control-Allow-Origin':'*'
          })
     };

    path: string;

    constructor(
        protected _http: HttpClient
        , protected _url: string
        , protected dummyData: T[]
    ) {
        this.path = `${environment.api.protocol}${environment.api.baseUrl}${this._url}`;
    }

    save(t: any): Observable<T> {
        if (environment.offline) {
            this.dummyData.push(t)
            return of(t);
        } else {
            return this._http.post<T>(this.path, t);
        }
    }

    saveList(t: T[]): Observable<T[]> {
        return this._http.post<T[]>(this.path, t);
    }
    updateList(id: ID, t: T[]): Observable<T[]> {
        return this._http.post<T[]>(`${this.path}/${id}`, t);
    }
    saveGetList(t: T): Observable<any> {
        return this._http.post<any>(this.path, t)
    }

    saveListMasive(t: T[],todos:number): Observable<any[]> {
        return this._http.post<any[]>(this.path+"/"+todos, t);
    }

    update(id: any, t: T): Observable<T> {
        if (environment.offline) {
            return of(t);
        } else {
            return this._http.post<T>(`${this.path}/${id}`, t, {});
        }
    }
    upload(files: FileList, id: ID): Observable<HttpEvent<any>> {
        const formData: FormData = new FormData();
        for (let x = 0; x < files.length; x++) {
            formData.append('file', files[x]);
        }
        const req = new HttpRequest('POST', this.path + "/" + id, formData, {
            reportProgress: true,
            responseType: 'json'
        });
        return this._http.request(req);
    }
    // upload(file: File, id: ID): Observable<HttpEvent<any>> {
    //     const formData: FormData = new FormData();
    //         formData.append('file', file);
    //     const req = new HttpRequest('POST', this.path + "/" + id, formData, {
    //         reportProgress: true,
    //         responseType: 'json'
    //     });
    //     return this._http.request(req);
    // }
    getFiles(): Observable<any> {
        return this._http.get(this.path);
    }

    findOne(id: ID): Observable<T> {
        return this._http.get<T>(this.path + "/" + id);
    }
    findById(id: ID): Observable<T[]> {
        return this._http.get<T[]>(`${this.path}/${id}`);
    }
    findByParams(mod: string, p: any): Observable<T[]> {
        let httpParams = new HttpParams({ fromObject: p });
        return this._http.get<T[]>(`${this.path} / ${mod}`, { params: httpParams });
    }

    findAll(): Observable<T[]> {
        if (environment.offline) {
            return of(this.dummyData)
        } else {
            return this._http.get<T[]>(this.path)
                .pipe(
                    //tap(_ => this.log('fetched')),
                    catchError(this.handleError<T[]>('findAll', []))
                );
        }
    }

    delete(id: ID): Observable<any> {
        return this._http.delete(`${this.path}/${id}`,this.httpOptions);
    }

    deletePost(id: ID): Observable<any> {
        return this._http.post(`${this.path}/${id}`,this.httpOptions);
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error); // log to console instead
            this.log(`${operation} failed: ${error.message}`);
            return of(result as T);
        };
    }

    private log(message: string) {
        console.log(message);
    }

}