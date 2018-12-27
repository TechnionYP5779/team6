"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const fs_1 = require("fs");
const os_1 = require("os");
const path = require("path");
const rxjs_1 = require("rxjs");
const operators_1 = require("rxjs/operators");
const ini = require('ini');
const lockfile = require('@yarnpkg/lockfile');
const pacote = require('pacote');
const npmPackageJsonCache = new Map();
let npmrc;
function readOptions(yarn = false) {
    // TODO: have a way to read options without using fs directly.
    const cwd = process.cwd();
    const baseFilename = yarn ? 'yarnrc' : 'npmrc';
    const dotFilename = '.' + baseFilename;
    let globalPrefix;
    if (process.env.PREFIX) {
        globalPrefix = process.env.PREFIX;
    }
    else {
        globalPrefix = path.dirname(process.execPath);
        if (process.platform !== 'win32') {
            globalPrefix = path.dirname(globalPrefix);
        }
    }
    const defaultConfigLocations = [
        path.join(globalPrefix, 'etc', baseFilename),
        path.join(os_1.homedir(), dotFilename),
    ];
    const projectConfigLocations = [];
    const root = path.parse(cwd).root;
    for (let curDir = path.dirname(cwd); curDir && curDir !== root; curDir = path.dirname(curDir)) {
        projectConfigLocations.unshift(path.join(curDir, dotFilename));
    }
    projectConfigLocations.push(path.join(cwd, dotFilename));
    let options = {};
    for (const location of [...defaultConfigLocations, ...projectConfigLocations]) {
        if (fs_1.existsSync(location)) {
            const data = fs_1.readFileSync(location, 'utf8');
            options = Object.assign({}, options, (yarn ? lockfile.parse(data) : ini.parse(data)));
            if (options.cafile) {
                const cafile = path.resolve(path.dirname(location), options.cafile);
                delete options.cafile;
                try {
                    options.ca = fs_1.readFileSync(cafile, 'utf8').replace(/\r?\n/, '\\n');
                }
                catch (_a) { }
            }
        }
    }
    return options;
}
/**
 * Get the NPM repository's package.json for a package. This is p
 * @param {string} packageName The package name to fetch.
 * @param {string} registryUrl The NPM Registry URL to use.
 * @param {LoggerApi} logger A logger instance to log debug information.
 * @returns An observable that will put the pacakge.json content.
 * @private
 */
function getNpmPackageJson(packageName, registryUrl, _logger, usingYarn = false) {
    const cachedResponse = npmPackageJsonCache.get(packageName);
    if (cachedResponse) {
        return cachedResponse;
    }
    if (!npmrc) {
        try {
            npmrc = readOptions();
        }
        catch (_a) { }
        if (usingYarn) {
            try {
                npmrc = Object.assign({}, npmrc, readOptions(true));
            }
            catch (_b) { }
        }
    }
    const resultPromise = pacote.packument(packageName, Object.assign({ 'full-metadata': true }, npmrc, { registry: registryUrl }));
    const response = rxjs_1.from(resultPromise).pipe(operators_1.shareReplay());
    npmPackageJsonCache.set(packageName, response);
    return response;
}
exports.getNpmPackageJson = getNpmPackageJson;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibnBtLmpzIiwic291cmNlUm9vdCI6Ii4vIiwic291cmNlcyI6WyJwYWNrYWdlcy9zY2hlbWF0aWNzL3VwZGF0ZS91cGRhdGUvbnBtLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBUUEsMkJBQThDO0FBQzlDLDJCQUE2QjtBQUM3Qiw2QkFBNkI7QUFDN0IsK0JBQXdDO0FBQ3hDLDhDQUE2QztBQUc3QyxNQUFNLEdBQUcsR0FBRyxPQUFPLENBQUMsS0FBSyxDQUFDLENBQUM7QUFDM0IsTUFBTSxRQUFRLEdBQUcsT0FBTyxDQUFDLG1CQUFtQixDQUFDLENBQUM7QUFDOUMsTUFBTSxNQUFNLEdBQUcsT0FBTyxDQUFDLFFBQVEsQ0FBQyxDQUFDO0FBRWpDLE1BQU0sbUJBQW1CLEdBQUcsSUFBSSxHQUFHLEVBQWdELENBQUM7QUFDcEYsSUFBSSxLQUFnQyxDQUFDO0FBR3JDLFNBQVMsV0FBVyxDQUFDLElBQUksR0FBRyxLQUFLO0lBQy9CLDhEQUE4RDtJQUM5RCxNQUFNLEdBQUcsR0FBRyxPQUFPLENBQUMsR0FBRyxFQUFFLENBQUM7SUFDMUIsTUFBTSxZQUFZLEdBQUcsSUFBSSxDQUFDLENBQUMsQ0FBQyxRQUFRLENBQUMsQ0FBQyxDQUFDLE9BQU8sQ0FBQztJQUMvQyxNQUFNLFdBQVcsR0FBRyxHQUFHLEdBQUcsWUFBWSxDQUFDO0lBRXZDLElBQUksWUFBb0IsQ0FBQztJQUN6QixJQUFJLE9BQU8sQ0FBQyxHQUFHLENBQUMsTUFBTSxFQUFFO1FBQ3RCLFlBQVksR0FBRyxPQUFPLENBQUMsR0FBRyxDQUFDLE1BQU0sQ0FBQztLQUNuQztTQUFNO1FBQ0wsWUFBWSxHQUFHLElBQUksQ0FBQyxPQUFPLENBQUMsT0FBTyxDQUFDLFFBQVEsQ0FBQyxDQUFDO1FBQzlDLElBQUksT0FBTyxDQUFDLFFBQVEsS0FBSyxPQUFPLEVBQUU7WUFDaEMsWUFBWSxHQUFHLElBQUksQ0FBQyxPQUFPLENBQUMsWUFBWSxDQUFDLENBQUM7U0FDM0M7S0FDRjtJQUVELE1BQU0sc0JB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QixDQUFDLEdBQUcsQ0FBQyxXQUFXLEVBQUUsUUFBUSxDQUFDLENBQUM7SUFFL0MsT0FBTyxRQUFRLENBQUM7QUFDbEIsQ0FBQztBQXBDRCw4Q0FvQ0MiLCJzb3VyY2VzQ29udGVudCI6WyIvKipcbiAqIEBsaWNlbnNlXG4gKiBDb3B5cmlnaHQgR29vZ2xlIEluYy4gQWxsIFJpZ2h0cyBSZXNlcnZlZC5cbiAqXG4gKiBVc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0IGNhbiBiZVxuICogZm91bmQgaW4gdGhlIExJQ0VOU0UgZmlsZSBhdCBodHRwczovL2FuZ3VsYXIuaW8vbGljZW5zZVxuICovXG5pbXBvcnQgeyBsb2dnaW5nIH0gZnJvbSAnQGFuZ3VsYXItZGV2a2l0L2NvcmUnO1xuaW1wb3J0IHsgZXhpc3RzU3luYywgcmVhZEZpbGVTeW5jIH0gZnJvbSAnZnMnO1xuaW1wb3J0IHsgaG9tZWRpciB9IGZyb20gJ29zJztcbmltcG9ydCAqIGFzIHBhdGggZnJvbSAncGF0aCc7XG5pbXBvcnQgeyBPYnNlcnZhYmxlLCBmcm9tIH0gZnJvbSAncnhqcyc7XG5pbXBvcnQgeyBzaGFyZVJlcGxheSB9IGZyb20gJ3J4anMvb3BlcmF0b3JzJztcbmltcG9ydCB7IE5wbVJlcG9zaXRvcnlQYWNrYWdlSnNvbiB9IGZyb20gJy4vbnBtLXBhY2thZ2UtanNvbic7XG5cbmNvbnN0IGluaSA9IHJlcXVpcmUoJ2luaScpO1xuY29uc3QgbG9ja2ZpbGUgPSByZXF1aXJlKCdAeWFybnBrZy9sb2NrZmlsZScpO1xuY29uc3QgcGFjb3RlID0gcmVxdWlyZSgncGFjb3RlJyk7XG5cbmNvbnN0IG5wbVBhY2thZ2VKc29uQ2FjaGUgPSBuZXcgTWFwPHN0cmluZywgT2JzZXJ2YWJsZTxOcG1SZXBvc2l0b3J5UGFja2FnZUpzb24+PigpO1xubGV0IG5wbXJjOiB7IFtrZXk6IHN0cmluZ106IHN0cmluZyB9O1xuXG5cbmZ1bmN0aW9uIHJlYWRPcHRpb25zKHlhcm4gPSBmYWxzZSk6IHsgW2tleTogc3RyaW5nXTogc3RyaW5nIH0ge1xuICAvLyBUT0RPOiBoYXZlIGEgd2F5IHRvIHJlYWQgb3B0aW9ucyB3aXRob3V0IHVzaW5nIGZzIGRpcmVjdGx5LlxuICBjb25zdCBjd2QgPSBwcm9jZXNzLmN3ZCgpO1xuICBjb25zdCBiYXNlRmlsZW5hbWUgPSB5YXJuID8gJ3lhcm5yYycgOiAnbnBtcmMnO1xuICBjb25zdCBkb3RGaWxlbmFtZSA9ICcuJyArIGJhc2VGaWxlbmFtZTtcblxuICBsZXQgZ2xvYmFsUHJlZml4OiBzdHJpbmc7XG4gIGlmIChwcm9jZXNzLmVudi5QUkVGSVgpIHtcbiAgICBnbG9iYWxQcmVmaXggPSBwcm9jZXNzLmVudi5QUkVGSVg7XG4gIH0gZWxzZSB7XG4gICAgZ2xvYmFsUHJlZml4ID0gcGF0aC5kaXJuYW1lKHByb2Nlc3MuZXhlY1BhdGgpO1xuICAgIGlmIChwcm9jZXNzLnBsYXRmb3JtICE9PSAnd2luMzInKSB7XG4gICAgICBnbG9iYWxQcmVmaXggPSBwYXRoLmRpcm5hbWUoZ2xvYmFsUHJlZml4KTtcbiAgICB9XG4gIH1cblxuICBjb25zdCBkZWZhdWx0Q29uZmlnTG9jYXRpb25zID0gW1xuICAgIHBhdGguam9pbihnbG9iYWxQcmVmaXgsICdldGMnLCBiYXNlRmlsZW5hbWUpLFxuICAgIHBhdGguam9pbihob21lZGlyKCksIGRvdEZpbGVuYW1lKSxcbiAgXTtcblxuICBjb25zdCBwcm9qZWN0Q29uZmlnTG9jYXRpb25zOiBzdHJpbmdbXSA9IFtdO1xuICBjb25zdCByb290ID0gcGF0aC5wYXJzZShjd2QpLnJvb3Q7XG4gIGZvciAobGV0IGN1ckRpciA9IHBhdGguZGlybmFtZShjd2QpOyBjdXJEaXIgJiYgY3VyRGlyICE9PSByb290OyBjdXJEaXIgPSBwYXRoLmRpcm5hbWUoY3VyRGlyKSkge1xuICAgIHByb2plY3RDb25maWdMb2NhdGlvbnMudW5zaGlmdChwYXRoLmpvaW4oY3VyRGlyLCBkb3RGaWxlbmFtZSkpO1xuICB9XG4gIHByb2plY3RDb25maWdMb2NhdGlvbnMucHVzaChwYXRoLmpvaW4oY3dkLCBkb3RGaWxlbmFtZSkpO1xuXG4gIGxldCBvcHRpb25zOiB7IFtrZXk6IHN0cmluZ106IHN0cmluZyB9ID0ge307XG4gIGZvciAoY29uc3QgbG9jYXRpb24gb2YgWy4uLmRlZmF1bHRDb25maWdMb2NhdGlvbnMsIC4uLnByb2plY3RDb25maWdMb2NhdGlvbnNdKSB7XG4gICAgaWYgKGV4aXN0c1N5bmMobG9jYXRpb24pKSB7XG4gICAgICBjb25zdCBkYXRhID0gcmVhZEZpbGVTeW5jKGxvY2F0aW9uLCAndXRmOCcpO1xuICAgICAgb3B0aW9ucyA9IHtcbiAgICAgICAgLi4ub3B0aW9ucyxcbiAgICAgICAgLi4uKHlhcm4gPyBsb2NrZmlsZS5wYXJzZShkYXRhKSA6IGluaS5wYXJzZShkYXRhKSksXG4gICAgICB9O1xuXG4gICAgICBpZiAob3B0aW9ucy5jYWZpbGUpIHtcbiAgICAgICAgY29uc3QgY2FmaWxlID0gcGF0aC5yZXNvbHZlKHBhdGguZGlybmFtZShsb2NhdGlvbiksIG9wdGlvbnMuY2FmaWxlKTtcbiAgICAgICAgZGVsZXRlIG9wdGlvbnMuY2FmaWxlO1xuICAgICAgICB0cnkge1xuICAgICAgICAgIG9wdGlvbnMuY2EgPSByZWFkRmlsZVN5bmMoY2FmaWxlLCAndXRmOCcpLnJlcGxhY2UoL1xccj9cXG4vLCAnXFxcXG4nKTtcbiAgICAgICAgfSBjYXRjaCB7IH1cbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICByZXR1cm4gb3B0aW9ucztcbn1cblxuLyoqXG4gKiBHZXQgdGhlIE5QTSByZXBvc2l0b3J5J3MgcGFja2FnZS5qc29uIGZvciBhIHBhY2thZ2UuIFRoaXMgaXMgcFxuICogQHBhcmFtIHtzdHJpbmd9IHBhY2thZ2VOYW1lIFRoZSBwYWNrYWdlIG5hbWUgdG8gZmV0Y2guXG4gKiBAcGFyYW0ge3N0cmluZ30gcmVnaXN0cnlVcmwgVGhlIE5QTSBSZWdpc3RyeSBVUkwgdG8gdXNlLlxuICogQHBhcmFtIHtMb2dnZXJBcGl9IGxvZ2dlciBBIGxvZ2dlciBpbnN0YW5jZSB0byBsb2cgZGVidWcgaW5mb3JtYXRpb24uXG4gKiBAcmV0dXJucyBBbiBvYnNlcnZhYmxlIHRoYXQgd2lsbCBwdXQgdGhlIHBhY2FrZ2UuanNvbiBjb250ZW50LlxuICogQHByaXZhdGVcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldE5wbVBhY2thZ2VKc29uKFxuICBwYWNrYWdlTmFtZTogc3RyaW5nLFxuICByZWdpc3RyeVVybDogc3RyaW5nIHwgdW5kZWZpbmVkLFxuICBfbG9nZ2VyOiBsb2dnaW5nLkxvZ2dlckFwaSxcbiAgdXNpbmdZYXJuID0gZmFsc2UsXG4pOiBPYnNlcnZhYmxlPFBhcnRpYWw8TnBtUmVwb3NpdG9yeVBhY2thZ2VKc29uPj4ge1xuICBjb25zdCBjYWNoZWRSZXNwb25zZSA9IG5wbVBhY2thZ2VKc29uQ2FjaGUuZ2V0KHBhY2thZ2VOYW1lKTtcbiAgaWYgKGNhY2hlZFJlc3BvbnNlKSB7XG4gICAgcmV0dXJuIGNhY2hlZFJlc3BvbnNlO1xuICB9XG5cbiAgaWYgKCFucG1yYykge1xuICAgIHRyeSB7XG4gICAgICBucG1yYyA9IHJlYWRPcHRpb25zKCk7XG4gICAgfSBjYXRjaCB7IH1cblxuICAgIGlmICh1c2luZ1lhcm4pIHtcbiAgICAgIHRyeSB7XG4gICAgICAgIG5wbXJjID0geyAuLi5ucG1yYywgLi4ucmVhZE9wdGlvbnModHJ1ZSkgfTtcbiAgICAgIH0gY2F0Y2ggeyB9XG4gICAgfVxuICB9XG5cbiAgY29uc3QgcmVzdWx0UHJvbWlzZSA9IHBhY290ZS5wYWNrdW1lbnQoXG4gICAgcGFja2FnZU5hbWUsXG4gICAge1xuICAgICAgJ2Z1bGwtbWV0YWRhdGEnOiB0cnVlLFxuICAgICAgLi4ubnBtcmMsXG4gICAgICByZWdpc3RyeTogcmVnaXN0cnlVcmwsXG4gICAgfSxcbiAgKTtcblxuICBjb25zdCByZXNwb25zZSA9IGZyb208TnBtUmVwb3NpdG9yeVBhY2thZ2VKc29uPihyZXN1bHRQcm9taXNlKS5waXBlKHNoYXJlUmVwbGF5KCkpO1xuICBucG1QYWNrYWdlSnNvbkNhY2hlLnNldChwYWNrYWdlTmFtZSwgcmVzcG9uc2UpO1xuXG4gIHJldHVybiByZXNwb25zZTtcbn1cbiJdfQ==