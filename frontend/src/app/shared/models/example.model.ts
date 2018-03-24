/**
 * Example Model
 *
 * Corresponds to ExampleRO in Java
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:57
 */
export class Example {
  private _exampleId: string;
  private _text: string;
  private _createdAt: number;

  constructor() {

  }

  get exampleId(): string {
    return this._exampleId;
  }

  get text(): string {
    return this._text;
  }

  get createdAt(): number {
    return this._createdAt;
  }
}
